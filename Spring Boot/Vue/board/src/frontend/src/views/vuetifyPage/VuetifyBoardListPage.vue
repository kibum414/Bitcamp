<template>
  <div align="center">
    <h2>뷰티파이 기반 게시판</h2>
    <!-- Vuetify Form 배치 -->
    <!-- VuetifyBoardListPageForm 컴포넌트의 listArray
         현재(VuetifyBoardListPage) 컴포넌트의 pageArray -->
    <vuetify-board-list-page-form :list-array="pageArray"/>
  </div>
</template>

<script>
import VuetifyBoardListPageForm from "@/components/vuetify/VuetifyBoardListPageForm";
import axios from "axios";

export default {
  name: "VuetifyBoardListPage",
  // VuetifyBoardListPageForm 컴포넌트 등록
  components: {
    VuetifyBoardListPageForm
  },
  data () {
    return {
      // pageArray 배열 초기화
      pageArray: []
    }
  },
  // 페이지가 만들어질 때
  created () {
    // axios로 해당 URL에 Get 요청
    axios.get('http://sample.bmaster.kro.kr/contacts')
      // 잘 되었다면
      .then(res => {
        // 해당 데이터 중 contacts 배열을 가지고 와
        // 현재 컴포넌트 pageArray에 저장
        this.pageArray = res.data.contacts
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<style scoped>

</style>