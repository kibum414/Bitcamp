import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {

  return (
    <>
      <nav className="navbar navbar-default">
        <div className="container">
          <div className="navbar-header">
            <button
              type="button"
              className="navbar-toggle"
              data-toggle="collapse"
              data-target="#myNavbar"
            >
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <Link to={'#'} className="navbar-brand">
              Me
            </Link>
            <div className="collapse navbar-collapse" id="myNavbar">
            <ul className="nav navbar-nav navbar-right">
              <li>
                <Link to={'/login'}>LOGIN</Link>
              </li>
              <li>
                <Link to={'/signup'}>SIGN UP</Link>
              </li>
              </ul>
              </div>
          </div>
          <div className="collapse navbar-collapse" id="myNavbar">
            <ul className="nav navbar-nav navbar-right">
              <li>
                <Link to={'#'}>WHO</Link>
              </li>
              <li>
                <Link to={'#'}>WHAT</Link>
              </li>
              <li>
                <Link to={'#'}>WHERE</Link>
              </li>
              <li>
                <Link to={'/board/news'}>NEWS</Link>
              </li>
              <li>
                <Link to={'/board/seoul-cctv'}>SEOUL CCTV</Link>
              </li>
              <li>
                <Link to={'/todo'}>TODO</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </>
  )
}

export default Header