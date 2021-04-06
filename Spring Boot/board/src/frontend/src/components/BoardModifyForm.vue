<template>
  <div>
    <h3>수정 형식</h3>
    <!-- prevent : submit을 onSubmit으로 매핑
         원래 submit : form에서 get 요청을 해서 어떤 URL로 보냄
         원래 form 동작 : method 지정해놓은 것을 통해 action 요청
                       또는 특정 html로 감 -->
    <form @submit.prevent="onSubmit">
      <!-- 전달받은 board 정보를 전부 출력 -->
      <table>
        <tr>
          <td>번호</td>
          <td><input type="text" :value="board.boardNo" disabled></td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td><input type="text" :value="board.regDate" disabled></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
          <td>작성자</td>
          <td><input type="text" :value="board.writer" disabled></td>
        </tr>
        <tr>
          <td>본문</td>
          <td><textarea v-model="content" rows="5"></textarea></td>
        </tr>
      </table>

      <div>
        <button type="submit">수정</button>
        <!-- 취소를 누르면 BoardReadPage로 돌아감 -->
        <router-link :to="{ name: 'BoardReadPage', params: { boardNo: board.boardNo.toString() } }">
          취소
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'BoardModifyForm',
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      // this: v-model로 매핑된 title, content
      // 현재 컴포넌트의 title, content에 수정한 내용 저장
      const { title, content } = this
      // 수정한 내용을 emit을 통해 ModifyPage의 submit 으로 보냄
      this.$emit('submit', { title, content })
    }
  },
  created () {
    this.title = this.board.title
    this.content = this.board.content
  }
}
</script>