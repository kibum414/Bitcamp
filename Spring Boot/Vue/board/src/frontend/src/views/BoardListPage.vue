<template>
  <div id="board">
    <h2>Board List</h2>
    <!-- 글쓰기를 누르면 BoardRegisterPage가 동작, 화면 전환 -->
    <router-link :to="{ name: 'BoardRegisterPage' }">
      글쓰기
    </router-link>
    <!-- 컴포넌트 이름에서 이니셜 단위마다 -를 하나씩 넣어서 태그로 사용 가능 -->
    <!-- :boards = v-bind:boards -->
    <!-- 컴포넌트인 BoardList의 boards와
         현재 컴포넌트의 "boards" 데이터를 주고 받겠다 -->
    <board-list :boards="boards"/>
  </div>
</template>

<script>
import BoardList from '@/components/BoardList'
/*
helper 함수 종류

mapState - state를 연결해주는 함수
mapGetters - getters를 연결해주는 함수
mapMutations - mutations를 연결해주는 함수
mapActions - actions를 연결해주는 함수
*/
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardListPage',
  // components: 내부에서 쓰려고 하는 컴포넌트 등록
  components: {
    // 등록을 해야 커스텀 태그 처럼 쓸 수 있음 (board-list)
    BoardList
  },
  // computed: 단순 작업에 사용
  /*

  */
  computed: {
    // state의 boards를 가져와서
    // board() { return this.$store.states.boards } 와 같음
    ...mapState(['boards'])
  },
  // 마운트 될 때 fetchBoardList를 실행하여 boards를 채움
  mounted () {
    this.fetchBoardList()
  },
  // fetchBoardList를 동작시키기 위해
  // mapActions에 의해서 store > actions.js에 있는 정보들을 매핑함으로써
  // fetchBoardList를 쓸 수 있게 됨
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}

