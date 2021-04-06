<template>
  <div id="board">
    <h2>Board List</h2>
    <!-- router-link가 어떤 링크로 연결되는지 확인 -->
    <!-- 글쓰기를 누르면 BoardRegisterPage가 동작 -->
    <router-link :to="{ name: 'BoardRegisterPage' }">
      글쓰기
    </router-link>
    <!-- 컴포턴트 이름에서 이니셜 단위마다 -를 하나씩 넣어서 태그로 사용 가능 -->
    <!-- 인자 전달 "boards" 값을 boards가 받아감 -->
    <!-- 컴포넌트 BoardList의 boards 데이터를 전달, 주고 받겠다 -->
    <board-list :boards="boards"/>
  </div>
</template>

<script>
import BoardList from '@/components/BoardList'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardListPage',
  // 내부에서 쓰려고 하는 컴포넌트 등록
  components: {
    // 등록을 해야 custom tag 처럼 쓸 수 있음
    BoardList
  },
  // 단순 작업에 사용
  computed: {
    // boards 정보 전달
    // state의 boards를 가져와서 export default 객체 안에 저장
    ...mapState(['boards'])
      },
  mounted () {
    // mount될 때 fetch되면서 board 채워짐
    this.fetchBoardList()
  },
  methods: {
    // store actions에 있는 정보들을 fetch 동작
    ...mapActions(['fetchBoardList'])
  }
  /*,
  beforeCreate: function () {
    console.log("BoardListPage Before Create: ")
  },
  // 출력 시 나오다 말다 하는 이유
  // 자바스크립트는 기본적으로 멀티 스레드
  // db에서 가져오지 못한 상태에서 출력했으므로 없다고 나옴
  // 1. 쿠키로
  // 2. 데이터를 다 가져올 때까지 대기
  //    -> Promise 배울 때 사용했던
  //       async, await 사용
  // 실제로 async와 await를 사용했지만 병렬로 돌아가는 루틴이 완화되지 않았음
  // 왜 ? 이미 나누어져 있는 루틴이기 때문에 그러함
  // boardlistpage와 boardlist 구동시키는 것들이 별개로 돌아감
  created: function () {
    console.log("BoardListPage Created: ")

    let $vm = this

    $vm.fetchBoardList()
  },
  beforeMount: function () {
    console.log("BoardListPage Before Mount: ")
  },
  // 라이프 사이클
  // create, mount, update, destroy 순
  // mount할 때 fetchBoardList 구동 ?
  mounted: function () {
    console.log("BoardListPage Mounted: ")

    this.fetchBoardList()
  },
  beforeUpdate: function () {
    console.log("BoardListPage Before Update: ")
  },
  updated: function () {
    console.log("BoardListPage Updated: ")
  },
  beforeDestroy: function () {
    console.log("BoardListPage Before Destroy: ")
  },
  destroyed: function () {
    console.log("BoardListPage Destroyed: ")
  }
  */
}
</script>

<style scoped>

</style>