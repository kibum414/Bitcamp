<template>
  <div align="center">
    <h2>게시글 읽기</h2>
    <!-- board 정보를 잘 얻어왔다면 board 정보를 BoardRead의 board에 세팅 -->
    <board-read v-if="board" :board="board"/>
    <!-- board 정보를 얻어오지 못했다면 로딩중 ... -->
    <p v-else>로딩중 ...</p>
    <!-- 수정을 누르면 BoardModifyPage 동작
         params로 boardNo를 보내고 있음 -->
    <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
      수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <!-- 목록을 누르면 BoardListPage 동작 -->
    <!-- 컴포넌트 이름에 대한 URL 매핑은 라우터에서 해놨기 때문에
         name 가지고 URL 매핑이 됨 -->
    <router-link :to="{ name: 'BoardListPage' }">
      목록
    </router-link>
  </div>
</template>

<script>
import BoardRead from '@/components/BoardRead'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardReadPage',
  // router에 props로 default: true로 했기 때문에
  // 파라미터로 보내는 정보가 별도 지시사항 없이도 props로 세팅됨
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    // board 가져옴
    ...mapState([
      'board'
    ])
  },
  created () {
    console.log('BoardReadPage created(): ' + this.boardNo)

    // 생성(create)할 때 fetchBoard 통해서 boardNo 획득해 옴
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    // fetchBoard 가져옴
    ...mapActions([
      'fetchBoard'
    ]),
    onDelete () {
      // this.board에는 게시글 정보가 다 들어있음
      // 그 중 boardNo만 갖겠다는 의미
      const { boardNo } = this.board
      // 번호만 넘겨서 delete 요청
      axios.delete(`http://localhost:7777/boards/${boardNo}`)
        // 처리가 잘 되었다면
        .then(() => {
          // 지우기 성공
          alert('Delete Success')
          // BoardListPage 로 돌아감
          this.$router.push({ name: 'BoardListPage' })
        })
    }
  },
  // mapState, mapActions, create를 통해서 board 획득
  // 획득한 정보를 기반으로 BoardRead를 보는 것
  components: {
    BoardRead
  }
}
</script>