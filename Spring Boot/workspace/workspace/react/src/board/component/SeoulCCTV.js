import React, { useState } from 'react'
import 'article/style/ArticleList.css'
import axios from 'axios'

const SeoulCCTV = () => {
  const [items, setItems] = useState({})
  axios.get(`../data/SeoulCCTV.json`) // function 구조 (데이터 없으므로 생략)
    .then(res => {
      setItems(res.data)
    }) // consumer 구조
    .catch(err => { }) // consumer 구조

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
              {
                items.map((item, i) => {
                  return (
                    <tr key={i}>
                      <td>{item.i}</td>
                      <td>{item.checktime}</td>
                      <td>{item.deviceid}</td>
                      <td></td>
                      <td></td>
                    </tr>
                  )
                })
              }
            </table>
          </div>
        </div>
      </form>
    </>
  )
}

export default SeoulCCTV