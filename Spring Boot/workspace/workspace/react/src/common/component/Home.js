import React from 'react'
import '../style/Home.css'
import '../style/Common.css'

const Home = () => {

  return (
    <>
      <nav className="navbar navbar-default">
        <div className="container">
          <div className="navbar-header">
            <button type="button" className="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
              <span className="icon-bar"></span>
            </button>
            <a className="navbar-brand" href="#">Me</a>
          </div>
          <div className="collapse navbar-collapse" id="myNavbar">
            <ul className="nav navbar-nav navbar-right">
              <li><a href="#">WHO</a></li>
              <li><a href="#">WHAT</a></li>
              <li><a href="#">WHERE</a></li>
            </ul>
          </div>
        </div>
      </nav>

      <div className="container-fluid bg-1 text-center">
        <h3 className="margin">Who Am I?</h3>
        <img src="https://www.w3schools.com/bootstrap/bird.jpg" className="img-responsive img-circle margin display_inline" alt="Bird" width="350" height="350" />
        <h3>I'm an adventurer</h3>
      </div>

      <div className="container-fluid bg-2 text-center">
        <h3 className="margin">What Am I?</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
        <a href="#" className="btn btn-default btn-lg">
          <span className="glyphicon glyphicon-search"></span> Search
        </a>
      </div>

      <div className="container-fluid bg-3 text-center">
        <h3 className="margin">Where To Find Me?</h3><br />
        <div className="row">
          <div className="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <img src="https://www.w3schools.com/bootstrap/birds1.jpg" className="img-responsive margin width_100per" alt="Image" />
          </div>
          <div className="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <img src="https://www.w3schools.com/bootstrap/birds2.jpg" className="img-responsive margin width_100per" alt="Image" />
          </div>
          <div className="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            <img src="https://www.w3schools.com/bootstrap/birds3.jpg" className="img-responsive margin width_100per" alt="Image" />
          </div>
        </div>
      </div>

      <footer className="container-fluid bg-4 text-center">
        <p>Bootstrap Theme Made By <a href="https://www.w3schools.com">www.w3schools.com</a></p>
      </footer>
    </>
  )
}

export default Home