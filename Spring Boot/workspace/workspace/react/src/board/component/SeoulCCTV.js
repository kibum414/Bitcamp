import React from 'react'
import 'article/style/ArticleList.css'

const SeoulCCTV = () => {

  return (
    <>
      <h1>게시판</h1>

      <form className="board_form">
        <div className="container">
          <div className="content">
            <table>
              <tr>
                <th>번호</th>
                <th>기준날짜</th>
                <th>카메라코드</th>
                <th>카메라명칭</th>
                <th>설명</th>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
          </div>
        </div>
      </form>
    </>
  )
}

export default SeoulCCTV