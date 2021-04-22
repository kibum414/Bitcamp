import { Route } from 'react-router-dom'
import { CounterContainer, CounterSliceContainer } from 'counter/index'
import { TodoApp } from 'todo/index'
import { Home } from 'common'
import { ArticleDetail, ArticleList, ArticleUpdate, ArticleWrite } from 'article/index'
import { SignUp, Login, UserDetail } from 'user/index'

function App() {
  return (
    <div className="App">

      <Route exact path='/' component={Home} />
      <Route exact path='/signup' component={SignUp} />
      <Route exact path='/login' component={Login} />
      <Route exact path='/user/detail' component={UserDetail} />
      {/* <Route exact path='/board/news' component={News} />
      <Route exact path='/board/seoul-cctv' component={SeoulCCTV} /> */}
      <Route exact path='/todo' component={TodoApp} />

      <Route exact path='/article/list' component={ArticleList} />
      <Route exact path='/article/write' component={ArticleWrite} />
      <Route exact path='/article/detail' component={ArticleDetail} />
      <Route exact path='/article/update' component={ArticleUpdate} />
    </div>
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <Route exact path='/' component={CounterContainer} />
    //     <Route exact path='/counter/counter-slice' component={CounterSliceContainer} />
        
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
  );
}

export default App;
