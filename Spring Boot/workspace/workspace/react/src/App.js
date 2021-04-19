import logo from 'logo.svg';
import 'App.css';
import { Route } from 'react-router-dom';
import Home from 'common/component/Home'
import { SignUpForm, LoginForm, UserDetail } from 'user/index'
import { News, SeoulCCTV, Counter, ReduxCounter } from 'board/index'
import { ArticleDetail, ArticleList, ArticleUpdate, ArticleWrite } from 'article/index'

const App = () => {
  return (
    <div className="App">
      <Route exact path='/' component={Home}></Route>
      <Route exact path='/user/sign-up' component={SignUpForm}></Route>
      <Route exact path='/user/login' component={LoginForm}></Route>
      <Route exact path='/user/user-detail' component={UserDetail}></Route>
      <Route exact path='/board/news' component={News}></Route>
      <Route exact path='/board/seoul-cctv' component={SeoulCCTV}></Route>
      <Route exact path='/board/counter' component={Counter}></Route>
      <Route exact path='/board/redux-counter' component={ReduxCounter}></Route>
      <Route exact path='/article/article-list' component={ArticleList}></Route>
      <Route exact path='/article/article-write' component={ArticleWrite}></Route>
      <Route exact path='/article/article-detail' component={ArticleDetail}></Route>
      <Route exact path='/article/article-update' component={ArticleUpdate}></Route>
    </div>
  );
}

export default App;
