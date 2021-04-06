<template>
  <div>
    <h3>게시판 보기</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">번호</th>
        <th align="center" width="320">제목</th>
        <th align="center" width="100">글쓴이</th>
        <th align="center" width="180">등록일자(버그수정중)</th>
      </tr>

      <!-- boards가 없거나 array 형식이면서 0이면 -->
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          List is empty
        </td>
      </tr>

      <!-- 데이터가 있다면 -->
      <!-- 받아온 boards 값을 사용 -->
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>
        <td align="left">
          <!-- 제목을 누르면 router-link 동작 -->
          <!-- params: 선택한 보드 엔티티의 번호를 가지고 가겠다. -->
          <router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: board.boardNo.toString() } }">
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'BoardList',
  // boards 넘겨주는 것은 mapState
  // 가져오게 만드는 애가 fetchBoardList
  // 가져온 boards 타입 지정
  props: {
    // boards에 대한 매핑은 props에서 boards는 array이다 라고 알려줌
    boards: {
      type: Array
    }
  }
  /*,
  beforeCreate: function () {
    console.log("BoardList Before Create: ")
  },
  created: function () {
    console.log("BoardList Created: ")
  },
  beforeMount: function () {
    console.log("BoardList Before Mount: ")
  },
  // 게시판 화면에서 undefined 나오는 이유
  // fetch를 ListPage에서 함
  // fetch 하기 전 mount 함
  mounted: function () {
    console.log("BoardList Mounted: " + this.boards)
  },
  beforeUpdate: function () {
    console.log("BoardList Before Update: ")
  },
  updated: function () {
    console.log("BoardList Updated: ")
  },
  beforeDestroy: function () {
    console.log("BoardList Before Destroy: ")
  },
  destroyed: function () {
    console.log("BoardList Destroyed: ")
  }
  */
}
</script>

<style scoped>

</style>