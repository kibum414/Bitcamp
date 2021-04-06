<template>
  <div align="center">
    <h2>게시판 수정</h2>
    <board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
    <p v-else>로딩중 ...</p>
  </div>
</template>

<script>
import BoardModifyForm from '@/components/BoardModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'BoardModifyPage',
  components: {
    BoardModifyForm
  },
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  created () {
    console.log('BoardModifyPage created()')
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.back()
      })
  },
  methods: {
    // BoardModifyForm에서 emit을 통해 수정한 내용이 넘어옴
    // 인자(payload) : title, content
    onSubmit (payload) {
      // 수정한 정보를 받아와서
      const { title, content } = payload
      console.log('BoardModifyPage payload: ' + payload)
      // 게시글 번호를 요청하여 수정한 정보를 전달
      // PutMapping
      axios.put(`http://localhost:7777/boards/${this.boardNo}`, { title, content })
        // 잘 처리되면 res 반환
        // res: boardNo에 해당하는 수정사항의 엔티티
        .then(res => {
          // 수정 성공
          alert('Modify Success')
          console.log('res: ' + res.data)
          // res.data에 엔티티가 들어있으므로
          // 엔티티 board 번호를 가지고 boardNo를 세팅해서
          // $router.push를 하여 BoardReadPage로 토스
          this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    },
    ...mapActions([
      'fetchBoard'
    ])
  }
}
</script>