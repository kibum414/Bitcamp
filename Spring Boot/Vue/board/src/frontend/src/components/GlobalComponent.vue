<template>
  <button @click="addCounter">{{ counter }}</button>
</template>

<script>
export default {
  name: "GlobalComponent",
  // GlobalComponent 연결 시 initial-counter
  // 로 표현
  props: ['initialCounter'],
  data: function () {
    return {
      counter: this.initialCounter
    }
  },
  methods: {
    addCounter () {
      this.counter++
    }
  }
}
</script>

<style scoped>

</style>