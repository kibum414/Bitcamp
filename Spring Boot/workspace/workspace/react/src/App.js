import logo from './logo.svg';
import './App.css';
import { Route } from 'react-router-dom';
import Home from './common/component/Home'
import SignUpForm from './user/component/SignUpForm'
import LoginForm from './user/component/LoginForm'
import UserDetail from './user/component/UserDetail'
import ArticleList from './board/component/ArticleList'
import ArticleWrite from './board/component/ArticleWrite'
import ArticleDetail from './board/component/ArticleDetail'
import ArticleUpdate from './board/component/ArticleUpdate'

function App() {
  return (
    <div className="App">
      <Route exact path='/' component={Home}></Route>
      <Route exact path='/user/sign_up' component={SignUpForm}></Route>
      <Route exact path='/user/login' component={LoginForm}></Route>
      <Route exact path='/user/user_detatil' component={UserDetail}></Route>
      <Route exact path='/board/article_list' component={ArticleList}></Route>
      <Route exact path='/board/article_write' component={ArticleWrite}></Route>
      <Route exact path='/board/article_detail' component={ArticleDetail}></Route>
      <Route exact path='/board/article_update' component={ArticleUpdate}></Route>
    </div>
  );
}

export default App;
