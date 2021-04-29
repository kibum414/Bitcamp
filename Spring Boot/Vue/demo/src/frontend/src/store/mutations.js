import {
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  CRAWL_START,
  FIND_ONE
} from './mutation-types'

export default {
  // for Board
  // 방해를 받지 않음
  // index에 있는 state, board값은 res
  // state의 boards에 저장
  [FETCH_BOARD_LIST] (state, boards) {
    state.boards = boards
  },
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
  // actions 에서 받아와서 데이터 세팅
  successGenerateRandomNumber (state, payload) {
    state.random = payload
  },

  // for Crawling
  [CRAWL_START] (state, payload) {
    state.lists = payload
  },
  [FIND_ONE] (state, payload) {
    state.news = payload
  }
}
