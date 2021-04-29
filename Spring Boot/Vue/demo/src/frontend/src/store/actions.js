import {
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  FIND_ONE,
  CRAWL_START
} from './mutation-types'

// axios 를 통해서 vue와 spring 간 데이터 주고받을 수 있음
import axios from 'axios'
import router from "@/router";

// mutation-types -> mutations -> actions에서 활용
export default {
  // 크롤링 하게 되면 웹사이트에서 싹 다 땡겨 오므로 굉장히 양이 많음
  // -> 비동기 처리 필요
  async crawlFind ({ commit }, category) {
    axios.get('http://localhost:7777/' + `${category}`)
      .then(({ data }) => {
        commit(CRAWL_START, data)
        if (window.location.pathname !== '/crawlCategory') {
          router.push('/crawlCategory')
        }
      })
  },
  async crawlFindOne ({ commit }, newsNo) {
    axios.get('http://localhost:7777/news/' + `${newsNo}`)
      .then(({ data }) => {
        commit(FIND_ONE, data)
        router.push('/crawlCategory/news')
      })
  },
  // 전체 리스트 얻어오는 것
  // ...Actions에서 요청할 때
  // commit이 여러 개(객체) 있을 수도 있으니 중괄호로 묶어서
  fetchBoardList ({ commit }) {
    // getmapping(리스트)
    // 리스트를 받아옴(res)
    return axios.get('http://localhost:7777/boards')
      .then(res => {
        // 데이터가 공유돼서 방해를 받으면 db 오염
        // res.data 리스트의 정보들이 들어 있음
        // FETCH_BOARD_LIST
        // 커밋하면 mutations로
        commit(FETCH_BOARD_LIST, res.data)
      })
  },
  fetchBoard ({ commit }, boardNo) {
    console.log('fetchBoard ' + commit + ', boardNo = ' + boardNo)

    // 가변인자 사용 위해 `` 사용
    return axios.get(`http://localhost:7777/boards/${boardNo}`)
      .then(res => {
        console.log('fetchBoard - res: ' + res.data)
        commit(FETCH_BOARD, res.data)
      })
  },
  generateRandomNumber ({ commit }) {
    // axios를 통해 spring으로 연결해서 데이터 통신
    axios.get('http://localhost:7777/random')
        .then((res) => {
            // data 이름 randNumber
            console.log('res = ' + parseInt(res.data.randNumber))
            // commit을 하므로 success는 mutation에 있어야 함
            commit('successGenerateRandomNumber',
                parseInt(res.data.randNumber))
        })
  }
}