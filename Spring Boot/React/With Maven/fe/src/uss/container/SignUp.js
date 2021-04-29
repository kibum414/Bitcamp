import '../component/SignUp.css';

const SignUp = () => 
  /*
  const formStyle = {
    border: "1px solid #ccc"
  }
  const inputStyle = {
    marginBottom: "15px"
  }
  const aStyle = {
    color: "dodgerblue"
  }
  */

  (
    <form action="/action_page.php" style={{ border: "1px solid #ccc" }}>
      <div className="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr />
        
        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter Name" name="name" required />

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required />

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required />

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required />

        <label>
          <input type="checkbox" checked="checked" name="remember" style={{ marginBottom: "15px" }} /> Remember me
        </label>

        <p>By creating an account you agree to our <a href="#" style={{ color: "dodgerblue" }}>Terms & Privacy</a>.</p>

        <div className="clearfix">
          <button type="button" className="cancelbtn">Cancel</button>
          <button type="submit" className="signupbtn">Sign Up</button>
        </div>
      </div>
    </form>

    /*
    <div className="App">
      <header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
      <p>
        Edit <code>src/App.js</code> and save to reload.
      </p>
      <a
        className="App-link"
        href="https://reactjs.org"
        target="_blank"
        rel="noopener noreferrer"
      >
        Learn React
      </a>
      </header>
    </div>
    */
  )

export default SignUp;
