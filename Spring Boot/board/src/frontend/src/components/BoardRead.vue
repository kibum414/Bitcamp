<template>
  <!-- BoardReadPage의 mapState, mapActions, create를 통해 획득한
       board 엔티티 하나에 대한 정보를 가지고 와서 뿌림 -->
  <div>
    <h3>게시글 보기</h3>
    <table>
      <tr>
        <td>번호</td>
        <td><input type="text" :value="board.boardNo" readonly></td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td><input type="text" :value="board.regDate" readonly></td>
      </tr>
      <tr>
        <td>제목</td>
        <td><input type="text" :value="board.title" readonly></td>
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" :value="board.wirter" readonly></td>
      </tr>
      <tr>
        <td>본문</td>
        <td><textarea :value="board.content" rows="5" readonly></textarea></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'BoardRead',
  // 전달받은 엔티티에 대한 정보
  props: {
    board: {
      type: Object,
      required: true
    }
  }
}
</script>