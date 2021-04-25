import React, { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import 'user/style/User.css'

const Login = () => {

  const [inputs, setInputs] = useState({})

  const { username, password } = inputs

  const userLogin = e => {
    e.preventDefault()

    axios({
      method: "post",
      url: 'http://localhost:8080/users/login',
      data: {
        username,
        password
      }
    })
      .then(res => {
        console.log(`res: ${JSON.stringify(res)}`)
        setInputs(res.data)

        alert('로그인 성공 !')
      })
      .catch(err => {
        console.log(`${err}`)

        alert('아이디와 비밀번호를 확인하세요.')
      })
  }

  const inputChange = e => {
    const { name, value } = e.target
    console.log(inputs)

    setInputs({
      ...inputs,
      [name]: value
    })
  }

  return (
    <>
      <h1>로그인</h1>

      <form className="user-form" onSubmit={userLogin}>
        <div className="container">
          <div className="content">
            <label htmlFor="username"><b>아이디</b></label>
            <input type="text" id="username" name="username" placeholder="아이디" onChange={inputChange} required />

            <label htmlFor="password"><b>비밀번호</b></label>
            <input type="password" id="password" name="password" placeholder="비밀번호" onChange={inputChange} required />
          </div>

          <div className="btn_area">
            <button type="submit" className="login_btn"><b>로그인</b></button>
            <Link to="/">
              <button type="button" className="cancel_btn"><b>돌아가기</b></button>
            </Link>
          </div>
        </div>
      </form>
    </>
  )
}

export default Login