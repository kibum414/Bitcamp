import { Route } from 'react-router-dom';
import { Home } from 'common/index'
import { SignUp, Login, UserDetail } from 'user/index'
import { News, SeoulCCTV } from 'board/index'
import { ArticleDetail, ArticleList, ArticleUpdate, ArticleWrite } from 'article/index'
import { TodoApp } from 'todo/index'

const App = () => {
  return (
    <div className="App">
      <Route exact path='/' component={Home} />
      <Route exact path='/signup' component={SignUp} />
      <Route exact path='/login' component={Login} />
      <Route exact path='/user/detail' component={UserDetail} />
      <Route exact path='/board/news' component={News} />
      <Route exact path='/board/seoul-cctv' component={SeoulCCTV} />
      <Route exact path='/todo' component={TodoApp} />

      <Route exact path='/article/list' component={ArticleList} />
      <Route exact path='/article/write' component={ArticleWrite} />
      <Route exact path='/article/detail' component={ArticleDetail} />
      <Route exact path='/article/update' component={ArticleUpdate} />
    </div>
  );
}

export default App;
