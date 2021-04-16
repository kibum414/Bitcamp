import React from 'react'
import ArticleList from 'article/component/ArticleList'
import HomeNav from 'common/component/HomeNav'
import HomeFooter from 'common/component/HomeFooter'

const News = () => {

  return (
    <>
      <HomeNav />
      <ArticleList />
      <HomeFooter />
    </>
  )
}

export default News