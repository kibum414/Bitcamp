import React from 'react'
import { Header, FirstContent, SecondContent, ThirdContent, Footer } from 'common'
import 'common/style/Home.css'
import 'common/style/Common.css'

const Home = () => {

  return (
    <div className="home">
      <Header />
      <FirstContent />
      <SecondContent />
      <ThirdContent />
      <Footer />
    </div>
  )
}

export default Home