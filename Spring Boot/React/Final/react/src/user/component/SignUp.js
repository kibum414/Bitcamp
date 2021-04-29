import React, { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import 'user/style/User.css'

const SignUp = ({ history }) => {

  const [userInfo, setUserInfo] = useState({})

  const { username, password, name, birthday, gender, email, phone } = userInfo

  const inputChange = e => {
    const { name, value } = e.target
    console.log(userInfo)

    setUserInfo({
      ...userInfo,
      [name]: value
    })
  }

  const userRegister = e => {
    e.preventDefault()

    alert(`회원가입`)

    axios({
      method: 'post',
      url: 'http://localhost:8080/users',
      data: {
        username,
        password,
        name,
        birthday,
        gender,
        email,
        phone,
        regdate: new Date()
      }
    })
      .then(res => {
        console.log(`res: ${JSON.stringify(res.data)}`)
        history.push('login')
      })
      .catch(err => {
        console.log(`${err}`)
      })
  }

  return (
    <>
      <h1>회원가입</h1>

      <form className="user-form" onSubmit={userRegister}>
        <div className="container">
          <div className="content">
            <label htmlFor="username"><b>아이디</b></label>
            <input type="text" id="username" name="username" placeholder="아이디" onChange={inputChange} required />

            <label htmlFor="password"><b>비밀번호</b></label>
            <input type="password" id="password" name="password" placeholder="비밀번호" onChange={inputChange} required />

            <label htmlFor="password-repeat"><b>비밀번호 재확인</b></label>
            <input type="password" id="password-repeat" name="password-repeat" placeholder="비밀번호 재확인" onChange={inputChange} required />

            <label htmlFor="name"><b>이름</b></label>
            <input type="text" id="name" name="name" placeholder="이름" onChange={inputChange} required />

            <label htmlFor="birthday"><b>생년월일</b></label>
            <input type="text" id="birthday" name="birthday" placeholder="생년월일" onChange={inputChange} required />

            <label htmlFor="gender"><b>성별</b></label>
            <select id="gender" name="gender" onChange={inputChange} required>
              <option value="">성별</option>
              <option value="남자">남자</option>
              <option value="여자">여자</option>
            </select>

            <label htmlFor="email"><b>이메일</b></label>
            <input type="text" id="email" name="email" placeholder="이메일" onChange={inputChange} required />

            <label htmlFor="phone"><b>휴대전화</b></label>
            <input type="text" id="phone" name="phone" placeholder="전화번호" onChange={inputChange} required />
          </div>

          <div className="btn_area">
            <button type="submit" className="signup_btn">가입하기</button>
            <Link to="/">
              <button type="button" className="cancel_btn"><b>돌아가기</b></button>
            </Link>
          </div>
        </div>
      </form>
    </>
  )
}

export default SignUp