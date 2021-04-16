import logo from 'logo.svg';
import 'App.css';
import { Route } from 'react-router-dom';
import Home from 'common/component/Home'
import SignUpForm from 'user/component/SignUpForm'
import LoginForm from 'user/component/LoginForm'
import UserDetail from 'user/component/UserDetail'
import News from 'board/component/News'
import SeoulCCTV from 'board/component/SeoulCCTV'
import ArticleList from 'article/component/ArticleList'
import ArticleWrite from 'article/component/ArticleWrite'
import ArticleDetail from 'article/component/ArticleDetail'
import ArticleUpdate from 'article/component/ArticleUpdate'

const App = () => {
  return (
    <div className="App">
      <Route exact path='/' component={Home}></Route>
      <Route exact path='/user/sign-up' component={SignUpForm}></Route>
      <Route exact path='/user/login' component={LoginForm}></Route>
      <Route exact path='/user/user-detail' component={UserDetail}></Route>
      <Route exact path='/board/news' component={News}></Route>
      <Route exact path='/board/seoul-cctv' component={SeoulCCTV}></Route>
      <Route exact path='/article/article-list' component={ArticleList}></Route>
      <Route exact path='/article/article-write' component={ArticleWrite}></Route>
      <Route exact path='/article/article-detail' component={ArticleDetail}></Route>
      <Route exact path='/article/article-update' component={ArticleUpdate}></Route>
    </div>
  );
}

export default App;
