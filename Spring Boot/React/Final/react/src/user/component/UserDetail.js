import React from 'react'
import 'user/style/UserDetail.css'

const UserDetail = () => {

  return (
    <>
      <h1>회원 정보</h1>

      <form className="user-form user-detail-form">
        <div className="container">
          <div className="content">
            <table>
              <tr>
                <th>아이디</th>
                <td>1</td>
              </tr>
              <tr>
                <th>이름</th>
                <td>1</td>
              </tr>
              <tr>
                <th>생년월일</th>
                <td>1</td>
              </tr>
              <tr>
                <th>성별</th>
                <td>1</td>
              </tr>
              <tr>
                <th>이메일</th>
                <td>1</td>
              </tr>
              <tr>
                <th>전화번호</th>
                <td>1</td>
              </tr>
            </table>
          </div>

          <div className="btn_area">
            <button type="submit" className="modify_btn"><b>수정</b></button>

            <button type="button" className="cancel_btn"><b>돌아가기</b></button>

          </div>
        </div>
      </form>
    </>
  )
}

export default UserDetail