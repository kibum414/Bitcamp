import React from 'react'
import { Header, Footer } from 'common'
import { ArticleList } from 'article'
import 'article/style/Article.css'
import 'article/style/ArticleList.css'

const ArticleApp = () => {

  return (
    <>
      <Header />
      <div className="article">
        <h1>게시판</h1>

        <form className="article-form article-list-form">
          <ArticleList />
        </form>
      </div>
      <Footer />
    </>
  )
}

export default ArticleApp