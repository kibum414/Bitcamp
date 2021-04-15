import React from 'react'
import '../style/Home.css'
import '../style/Common.css'
import HomeNav from './HomeNav'
import HomeContainerFirst from './HomeContainerFirst'
import HomeContainerSecond from './HomeContainerSecond'
import HomeContainerThird from './HomeContainerThird'
import HomeFooter from './HomeFooter'

const Home = () => {

  return (
    <>
      <HomeNav />

      <HomeContainerFirst />

      <HomeContainerSecond />

      <HomeContainerThird />

      <HomeFooter />
    </>
  )
}

export default Home