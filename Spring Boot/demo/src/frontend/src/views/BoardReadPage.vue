<template>
  <div align="center">
    <h2>게시글 읽기</h2>
    <!-- board-read: import BoardRead 를 함으로써 사용 가능 -->
    <board-read v-if="board" :board="board"/>
    <p v-else>로딩중 ...</p>
    <router-link :to="{ name: 'BoardModifyPage', params: { boardNo } }">
      수정
    </router-link>
    <button @click="onDelete">Delete</button>
    <router-link :to="{ name: 'BoardListPage' }">
      목록
    </router-link>
  </div>
</template>

<script>
// template의 board-read를 사용하기 위해 필요한 import
import BoardRead from '@/components/BoardRead'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardReadPage',
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    // states 자동 매핑
    ...mapState(['board'])
  },
  created () {
    console.log('BoardReadPage created(): ' + this.boardNo)
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    ...mapActions(['fetchBoard']),
    // board 번호를 가지고 delete 요청 보냄
    onDelete () {
      // board의 여러 정보 중 번호만 갖겠다.
      const { boardNo } = this.board
      // `로 해야 ${}가 숫자로 바뀌어서 처리됨
      // delete는 deletemapping
      axios.delete(`http://localhost:7777/boards/${boardNo}`)
        .then(() => {
          alert('삭제 성공')
          this.$router.push({ name: 'BoardListPage' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  },
  components: {
    BoardRead
  }
}
</script>

<style scoped>
</style>