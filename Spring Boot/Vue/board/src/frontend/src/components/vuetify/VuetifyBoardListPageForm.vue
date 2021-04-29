<template>
  <div>
    <table>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>연락처</th>
        <th>주소</th>
      </tr>
      <!-- computed 영역에서 계산된 paginatedData의 반환값
           (페이지 당 리스트 값) 하나씩 출력 -->
      <tr v-for="page in paginatedData" :key="page.no">
        <td>{{ page.no }}</td>
        <td>{{ page.name }}</td>
        <td>{{ page.tel }}</td>
        <td>{{ page.address }}</td>
      </tr>
    </table>

    <div style="margin-top: 1.5rem; text-align: center;
                width: 15rem; height: 2rem; letter-spacing: 2px;">
      <!-- pageNum이 0(첫 페이지)이면 비활성화, 클릭 시 prevPage 메서드 -->
      <button :disabled="pageNum === 0" @click="prevPage">
        이전
      </button>
      <span style="padding: 0 10px;">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <!-- pageNum이 페이지 개수 - 1(마지막 페이지)이면 비활성화, 클릭 시 nextPage 메서드 -->
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
    // 배열 타입
    // 해당 props를 부모 컴포넌트에서 넘겨받지 않았는데
    // required: true로 설정되어 있으면 에러 발생. 렌더링은 됨.
    listArray: {
      type: Array,
      required: true
    },
    // 숫자 타입
    // 디폴트 값 20
    pageSize: {
      type: Number,
      required: false,
      default: 20
    }
  },
  methods: {
    // 다음 페이지로
    nextPage () {
      this.pageNum += 1
    },
    // 이전 페이지로
    prevPage () {
      this.pageNum -= 1
    }
  },
  computed: {
    // VuetifyBoardListPage 컴포넌트에서
    // axios를 통해 얻어온 연락처 리스트 총 개수와
    // default 값으로 지정한 한 페이지당 연락처 개수를 이용하여
    // 페이지 수 계산
    pageCount () {
      // 연락처 리스트 개수
      const listLen = this.listArray.length
      // 한 페이지 당 연락처 개수 : props에서 default로 지정한 20개
      const listSize = this.pageSize

      // 페이지 개수 계산
      let page = Math.floor(listLen / listSize)
      // 나머지가 있다면 페이지 수 + 1
      if (listLen % listSize > 0) {
        page += 1
      }

      // 페이지 개수 반환
      return page
    },
    // 페이지 당 시작 번호와 끝 번호를 계산하여
    // 해당 범위 내 연락처 리스트 리턴하는 메서드
    paginatedData () {
      // 시작 : 페이지 번호 * 한 페이지 당 연락처 개수
      const start = this.pageNum * this.pageSize
      // 끝 : 해당 페이지 시작 번호 + 한 페이지 당 연락처 개수
      const end = start + this.pageSize

      // 범위 내 리스트 끊어서 반환
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
  border_bottom: 1px solid #333333;
}
</style>