<template>
  <div>
    <h3>게시판</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">번호</th>
        <th align="center" width="320">제목</th>
        <th align="center" width="100">작성자</th>
        <th align="center" width="180">등록일자(버그수정중)</th>
      </tr>

      <!-- 자바스크립트에서 Json은 배열(리스트 타입) -->
      <!-- boards가 없거나 boards가 배열이고 길이가 0이면 (데이터가 없다면)
           List is empty 출력 -->
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          List is empty
        </td>
      </tr>

      <!-- 데이터가 있다면 boards에서 하나씩 꺼내와서
           번호, 제목, 작성자, 등록일자 등등 뿌려줌 -->
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>
        <td align="left">
          <!-- 게시글 제목 누르면 BoardReadPage 동작, 페이지 전환 -->
          <!-- params: 선택한 board 엔티티의 번호를 가지고 가겠다. -->
          <router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: board.boardNo.toString() } }">
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </tagle>
  </div>
</template>

<script>
export default {
  name: 'BoardList',
  props: {
    // boards에 대한 매핑은
    // props에서 상호 간 전달하는 데이터(boards)는 Array 타입이다
    // 라고 알려주었기 때문에 가능
    boards: {
      type: Array
    }
  }
}
</script>