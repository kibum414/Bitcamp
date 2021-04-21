import React from 'react'
import 'user/style/SignUp.css'

const SignUp = () => {

  return (
    <>
      <h1>회원가입</h1>
      
      <form className="join_form">
        <div className="container">
          <div className="content">
            <label htmlFor="username"><b>아이디</b></label>
            <input type="text" id="username" name="username" placeholder="아이디" required />

            <label htmlFor="password"><b>비밀번호</b></label>
            <input type="password" id="password" name="password" placeholder="비밀번호" required />

            <label htmlFor="password-repeat"><b>비밀번호 재확인</b></label>
            <input type="password" id="password-repeat" name="password-repeat" placeholder="비밀번호 재확인" required />

            <label htmlFor="name"><b>이름</b></label>
            <input type="text" id="name" name="name" placeholder="이름" required />

            <label htmlFor="birthday"><b>생년월일</b></label>
            <input type="text" id="birthday" name="birthday" placeholder="생년월일" required />

            <label htmlFor="gender"><b>성별</b></label>
            <select id="gender" name="gender" required>
              <option value="">성별</option>
              <option value="남자">남자</option>
              <option value="여자">여자</option>
            </select>

            <label htmlFor="email"><b>이메일</b></label>
            <input type="text" id="email" name="email" placeholder="이메일" required />

            <label htmlFor="phone"><b>휴대전화</b></label>
            <input type="text" id="phone" name="phone" placeholder="전화번호" required />
          </div>

          <div className="btn_area">
            <button type="submit" className="signup_btn"><b>가입하기</b></button>
            
              <button type="button" className="cancel_btn"><b>돌아가기</b></button>
            
          </div>
        </div>
      </form>
    </>
  )
}

export default SignUp