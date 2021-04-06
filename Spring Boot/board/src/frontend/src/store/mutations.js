import {
  FETCH_BOARD_LIST,
  FETCH_BOARD
} from './mutation-types'

export default {
  // for Board
  // state: store > index.js 에 있는 state를 매핑한 것
  // boards: res에 있는 데이터 값
  [FETCH_BOARD_LIST] (state, boards) {
    // state의 boards에 Spring으로부터 가져온 boards 값 저장
    state.boards = boards
  },
  // board 하나에 대한 결과를 state의 board에 저장
  [FETCH_BOARD] (state, board) {
    state.board = board
  },

  // for Test
  increment (state) {
    state.count++
  },
  decrement (state) {
    state.count--
  },
  // actions에서 받아와서 데이터 세팅
  successGenerateRandomNumber (state, payload) {
    state.random = payload
  }
}