import React from 'react'
import '../style/ArticleList.css'

const ArticleList = () => {

  return (
    <>
      <h1>게시판</h1>

      <form className="board_form">
        <div className="container">
          <div className="content">
            <table>
              <tr>
                <th>번호</th>
                <th className="subject">제목</th>
                <th>작성자</th>
                <th>작성일</th>
              </tr>
              <tr>
                <td>1</td>
                <td>제목1</td>
                <td>작성자1</td>
                <td>2021-04-14</td>
              </tr>
              <tr>
                <td>2</td>
                <td>제목2</td>
                <td>작성자2</td>
                <td>2021-04-14</td>
              </tr>
              <tr>
                <td>3</td>
                <td>제목3</td>
                <td>작성자3</td>
                <td>2021-04-14</td>
              </tr>
            </table>
          </div>

          <div className="btn_area">
            <button type="submit" className="write_btn"><b>글쓰기</b></button>
          </div>
        </div>
      </form>
    </>
  )
}

export default ArticleList