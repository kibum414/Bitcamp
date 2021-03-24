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
    // store에 있는 fetchBoard
    this.fetchBoard(this.boardNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.back()
      })
  },
  // modifyform에서 가져오는 게 title, content 이므로 맞춰야 함
  methods: {
    onSubmit (payload) {
      const { title, content } = payload
      console.log('BoardModifyPage payload: ' + payload)
      // 수정은 putmapping, putmapping 하는 url을 이것으로 하겠다.
      axios.put(`http://localhost:7777/boards/${this.boardNo}`, { title, content })
        .then(res => {
          alert('Modify Success')
          console.log('res: ' + res.data)
          this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    },
    ...mapActions(['fetchBoard'])
  }
}
</script>

<style scoped>

</style>