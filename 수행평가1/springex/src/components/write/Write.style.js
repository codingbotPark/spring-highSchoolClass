import styled from "styled-components";

export const Wrapper = styled.div`
  width: 100%;
  /* height:calc(100vh - 80px); */
  /* min-height:calc(100vh - 80px); */
  display: flex;
  justify-content: center;
  margin-top: 40px;
`;

export const WrapperLayout = styled.div`
  display: flex;
  flex-direction: column;
  width: 90%;
`;

export const InnerWrapper = styled.div`
  width: 100%;
  /* width:90%; */
  min-height: calc(100vh - 80px);
  display: flex;
`;

const Area = styled.div`
  width: 50%;

  display: flex;
  flex-direction: column;
  height: 100%;
  overflow-y: auto;
`;
export const InputArea = styled.div`
  width: 50%;

  display: flex;
  flex-direction: column;
  height: 100%;
  overflow-y: auto;
  * {
    ::placeholder {
      color: lightgray;
    }
  }
  textarea {
    resize: none;
    border: none;
    padding: 0px;
    outline: none;
    font-family: "Tahoma";
  }
  padding-right: 30px;
`;

export const ResultArea = styled(Area)`
  padding-left: 30px;
  display: flex;
  flex-direction: column;
`;

export const LatTemp = styled.div`
  height: 1px;
  background-color: lightgray;
  width: 44%;
`;
export const LngTemp = styled.div`
  height: 95%;
  width: 1.5px;
  background-color: lightgray;
`;

export const InputTitle = styled.textarea`
  font-size: 50px;
  height: 70px;
  font-weight: bold;
  transition: all 0s;
`;
export const InputBook = styled.textarea`
  margin: 10px 0px;
  font-size: 25px;
  font-weight: bold;
  height: 38px;
  transition: all 0s;
`;
export const InputContent = styled.textarea`
  margin: 10px 0px;
  font-size: 20px;
  font-weight: normal;
  transition: all 0s;
  line-height: 34px;
`;

export const ResultTitle = styled.h1`
  font-size: 50px;
  height: fit-content;
  font-weight: bold;
  margin: 0px;
  min-height: 70px;
`;
export const ResultBook = styled.h3`
  height: fit-content;
  margin: 10px 0px;
  font-size: 25px;
  font-weight: bold;
  min-height: 38px;
`;
/* export const ResultContent = styled.p` */
export const ResultContent = styled.div`
  margin: 0px 0px 10px 0px;
  font-size: 20px;
  font-weight: 500;
  height: fit-content;
  white-space: pre-wrap;
`;

export const SubmitArea = styled.div`
  width: 100%;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-wrap: wrap;
`;
export const SubmitAreaWrapper = styled.div`
  width: fit-content;
  display: flex;
  justify-content: center;
`;
export const SubmitImgWrapper = styled.div`
  height: 300px;
  width: 400px;
  margin: 50px;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
  > img {
    width: 100%;
    height: 100%;
    border-radius: 15px;
    object-fit: cover;
  }
`;
export const SubmitImgButton = styled.div`
  margin-top: 20px;
  > input {
    display: none;
  }
  > label {
    display: inline-block;
    padding: 0.5em 0.75em;
    color: white;
    font-size: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: ${(props) => props.theme.main};
    cursor: pointer;
    border-radius: 0.25em;
  }
`;

export const SubmitButtonWrapper = styled.div`
  height: 300px;
  width: 400px;
  margin: 50px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: Center;

  > button {
    /* padding: 0.5em 0.75em; */
    padding: 1em 1.5em;
    color: white;
    font-size: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: ${(props) => props.theme.main};
    cursor: pointer;
    border-radius: 0.25em;
  }
`;

export const AuthorInput = styled.div`
  display: flex;
  justify-content: center;
  > div {
    background-color: ${(props) => props.theme.main};
    color: white;
    padding: 0.5em 0.75em;
    border-radius: 0.4em 0px 0px 0.4em;
    cursor: default;
    padding: 10px 15px;
  }
  > input {
    border: 1px solid ${(props) => props.theme.main};
    border-radius: 0px 0.4em 0.4em 0px;
    padding: 10px 15px;

  }
`;

export const SubmitImgInputArea = styled.div`
  width: 100%;
  height: 100%;
  background-color: lightgray;
  border-radius: 15px;
  display: flex;
  justify-content: Center;
  align-items: Center;
  flex-direction: Column;
  > input {
    display: none;
  }
  > label {
    display: inline-block;
    padding: 0.5em 0.75em;
    color: white;
    font-size: inherit;
    line-height: normal;
    vertical-align: middle;
    background-color: ${(props) => props.theme.main};
    cursor: pointer;
    border-radius: 0.25em;
  }
`;
