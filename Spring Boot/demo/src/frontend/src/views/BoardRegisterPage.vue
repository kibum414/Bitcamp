<template>
  <div align="center">
    <h2>게시글 등록</h2>
    <!-- BoardeRegisterForm 으로 전달, 1번 -->
    <board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import BoardRegisterForm from '@/components/BoardRegisterForm'
// 글을 쓰고 등록할 때 spring 에 요청하기 위해 axios 필요
// HTTP 통신을 하는데 사용하는 JS 라이브러리
// Promise
import axios from 'axios'
export default {
  name: 'BoardRegisterPage',
  components: {
    BoardRegisterForm
  },
  methods: {
    onSubmit (payload) {
      console.log('BoardRegisterPage onSubmit()')
      const { title, content, writer } = payload
      axios.post('http://localhost:7777/boards', { title, writer, content })
        .then(res => {
          console.log(res)
          alert('Register Success')
          this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: res.data.boardNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
  /*,
  beforeCreate: function () {
    console.log("BoardRegisterPage Before Create: ")
  },
  created: function () {
    console.log("BoardRegisterPage Created: ")
  },
  beforeMount: function () {
    console.log("BoardRegisterPage Before Mount: ")
  },
  mounted: function () {
    console.log("BoardRegisterPage Mounted: ")
  },
  beforeUpdate: function () {
    console.log("BoardRegisterPage Before Update: ")
  },
  updated: function () {
    console.log("BoardRegisterPage Updated: ")
  },
  beforeDestroy: function () {
    console.log("BoardRegisterPage Before Destroy: ")
  },
  destroyed: function () {
    console.log("BoardRegisterPage Destroyed: ")
  }
  */
}
</script>

<style scoped>

</style>

/*
created: 데이터 초기화
mounted: DOM 조작에 대한 목적

binding: 데이터 매핑
동적 바인딩: 객체, C의 포인터
정적 바인딩: 배열(스택에 배치, 동적으로 배치 가능)

DOM
*/