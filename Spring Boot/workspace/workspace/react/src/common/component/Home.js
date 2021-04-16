import React from 'react'
import 'common/style/Home.css'
import 'common/style/Common.css'
import HomeNav from 'common/component/HomeNav'
import HomeContainerFirst from 'common/component/HomeContainerFirst'
import HomeContainerSecond from 'common/component/HomeContainerSecond'
import HomeContainerThird from 'common/component/HomeContainerThird'
import HomeFooter from 'common/component/HomeFooter'

const Home = () => {

  return (
    <div className="home">
      <HomeNav />
      <HomeContainerFirst />
      <HomeContainerSecond />
      <HomeContainerThird />
      <HomeFooter />
    </div>
  )
}

export default Home