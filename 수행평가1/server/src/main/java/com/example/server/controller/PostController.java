package com.example.server.controller;

import com.example.server.dto.CreatePost;
import com.example.server.dto.LoadPost;
import com.example.server.dto.UpdatePost;
import com.example.server.entity.Image;
import com.example.server.entity.Post;
import com.example.server.repository.ImageRepository;
import com.example.server.repository.PostRepository;
import com.example.server.util.Comparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @GetMapping("/list")
    public List<LoadPost> findall(){
        List<LoadPost> postList = postRepository.findAll().stream().map((i) -> {
            return new LoadPost(
                    i.getId(),
                    i.getTitle(),
                    i.getBookName(),
                    i.getContent(),
                    i.getWriter(),
                    i.getTime(),
                    i.getViews()
            );
        }).collect(Collectors.toList());

        System.out.println(postList);
        postList.sort(new Comparator());

        return postList;
    }
//    @PostMapping(value = "create")
    @PostMapping(value = "writer")
    public void create(
            @RequestBody CreatePost createPost
    ){
        Image image = imageRepository.findById(createPost.getImageId())
                .orElseThrow(() -> {throw new RuntimeException("???????????? ????????????");});
        // ???????????? ??? ??????
        Post tempPost = new Post(
                createPost.getTitle(),
                createPost.getBookName(),
                createPost.getContent(),
                createPost.getWriter(),
                image.getImgName(),
                image.getImgByte()
        );
        postRepository.save(tempPost);
    }

    // ??????????????? ?????? ?????????
    @PostMapping("update/{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestBody UpdatePost updatePost
    ){
        Image image = imageRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("???????????? ????????????");});
        
        Post findedPost = postRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("??????????????? ?????? ??? ???????????????");});
        findedPost.updatePost(
                updatePost.getTitle(),
                updatePost.getBookName(),
                updatePost.getContent(),
                updatePost.getWriter(),
                image.getImgName(),
                image.getImgByte(),
                LocalDateTime.now()
        );
        postRepository.save(findedPost);
    }

    
    // ???????????? ??? ?????? img
    @PostMapping("update/image/{id}")
    public Long image(
            @PathVariable("id") Long id,
            MultipartFile file
    ) {
        Image upImg = imageRepository.findById(id).orElseThrow(() -> {throw  new RuntimeException("???????????? ??? ???????????????");});
        try {
            upImg.updateImage(
                    file.getName(),
                    file.getBytes()
            );

            return imageRepository.save(upImg).getImageId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("image")
    public Long image(
            MultipartFile file
    ) {
        try {
            Image image = new Image(file.getName(), file.getBytes());

            return imageRepository.save(image).getImageId();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    
    @DeleteMapping("delete/{id}")
    public void delete(
            @PathVariable("id") Long id
    ){
        Post post = postRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("??????????????? ?????? ??? ???????????????");});
        Image image = imageRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("??????????????? ???????????? ??? ???????????????");});
        postRepository.delete(post);
        imageRepository.delete(image);
    }


//    @GetMapping("find/{id}")
    @GetMapping("view/{id}")
    public LoadPost find(
            @PathVariable("id") Long id
    ){
        Post findedPost = postRepository.findById(id).orElseThrow(() -> {throw new RuntimeException("?????? ??? ???????????????");});
        findedPost.viewCount();
        postRepository.save(findedPost);
        return new LoadPost(
                findedPost.getId(),
                findedPost.getTitle(),
                findedPost.getBookName(),
                findedPost.getContent(),
                findedPost.getWriter(),
                findedPost.getTime(),
                findedPost.getViews()
        );
    }


    // ????????? src??? ????????? ??? ?????????
    @GetMapping(value = "/img/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> getImg(
            @PathVariable("id") Long id // pathValue????????????
    ){
        Post post = postRepository.findById(id) // id
                .orElseThrow(() -> {throw new RuntimeException("");});

        String contentDisposition = String.format("attachment; filename=\"%s\"", post.getImgName());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(post.getImgByte());
    }
}
