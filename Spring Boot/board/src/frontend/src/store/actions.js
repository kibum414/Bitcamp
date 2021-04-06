import {
  FETCH_BOARD_LIST,
  FETCH_BOARD
} from './mutation-types'

// axios: Spring과 Front 간을 연결
import axios from 'axios'

// mutation-types -> mutations -> actions에서 활용
export default {
  // commit 이라는 게 여러 개 있을 수도 있으니 {}로 묶어줌
  // commit이 여러 개가 된다는 것 자체가 객체 라는 소리
  fetchBoardList ({ commit }) {
    // GetMapping (list()에 요청)
    // list()에 요청하여 list를 받아온 결과가 res에 저장됨
    // res.data : 리스트의 정보들이 모두 들어 있음
    return axios.get('http://localhost:7777/boards')
      .then(res => {
        // FETCH_BOARD_LIST
        // commit을 하면 mutations로 감
        commit(FETCH_BOARD_LIST, res.data)
      })
  },
  fetchBoard ({ commit }, boardNo) {
    console.log('fetchBoard ' + commit + ', boardNo = ' + boardNo)
    // GetMapping("/{boardNo}")
    // 전달받은 board 하나 값이 res에 들어 있음
    // res.data : board 엔티티 하나의 결과 값이 들어 있음
    // 가변인자 사용 위해 `` 사용
    return axios.get(`http://localhost:7777/boards/${boardNo}`)
      .then(res => {
        console.log('fetchBoard - res: ' + res.data)
        commit(FETCH_BOARD, res.data)
      })
  },
  generateRandomNumber ({ commit }) {
    // axios를 통해 Spring으로 연결해서 데이터 통신
    axios.get('http://localhost:7777/random')
      .then(res => {
        // data 이름 randNumber
        console.log('res = ' + parseInt(res.data.randNumber))
        // commit을 하므로 success~ 는 mutations에 있어야 함
        commit('successGenerateRandomNumber',
            parseInt(res.data.randNumber))
      })
  }
}