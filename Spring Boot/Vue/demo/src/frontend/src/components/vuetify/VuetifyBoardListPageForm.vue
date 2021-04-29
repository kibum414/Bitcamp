<template>
  <div>
    <table>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>연락처</th>
        <th>주소</th>
      </tr>
      <tr v-for="page in paginatedData" :key="page.no">
        <td>{{ page.no }}</td>
        <td>{{ page.name }}</td>
        <td>{{ page.tel }}</td>
        <td>{{ page.address }}</td>
      </tr>
    </table>
    <div style="margin-top: 1.5rem; text-align: center;
                width: 15rem; height: 2rem; letter-spacing: 2px;">
      <button :disabled="pageNum === 0" @click="prevPage">
        이전
      </button>
      <span style="padding: 0 10px;">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage">
        다음
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "VuetifyBoardListPageForm",
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    listArray: {
      type: Array,
      // 반드시 필요
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      // 지정하지 않을 경우 20개
      default: 20
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  },
  computed: {
    pageCount () {
      // 전체 길이
      const listLen = this.listArray.length
      // 전체 사이즈
      const listSize = this.pageSize

      // 게시글들의 전체 개수 / 페이지 사이즈(한 페이지 게시글 몇 개)
      let page = Math.floor(listLen / listSize)
      // 나머지가 생기면 다음 페이지 하나 더 만들기
      if (listLen % listSize > 0) {
        page += 1
      }

      return page
    },
    paginatedData () {
      // 몇 페이지 * 페이지 당 게시글 개수
      // 페이지 번호가 몇이냐에 따라 시작 위치 달라짐
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize
      return this.listArray.slice(start, end)
    }
  }
}
</script>

<style scoped>
table {
  width: 70%;
  border-collapse: collapse;
}

table tr {
  border-bottom: 1px solid #333333;
}
</style>