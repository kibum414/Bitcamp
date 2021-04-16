import React from 'react'
import 'user/style/LoginForm.css'

const LoginForm = () => {

  return (
    <>
      <h1>로그인</h1>

      <form className="login_form">
        <div className="container">
          <div className="content">
            <label htmlFor="username"><b>아이디</b></label>
            <input type="text" id="username" name="username" placeholder="아이디" required />

            <label htmlFor="password"><b>비밀번호</b></label>
            <input type="password" id="password" name="password" placeholder="비밀번호" required />
          </div>

          <div className="btn_area">
            <button type="submit" className="login_btn"><b>로그인</b></button>

            <button type="button" className="cancel_btn"><b>돌아가기</b></button>

          </div>
        </div>
      </form>
    </>
  )
}

export default LoginForm