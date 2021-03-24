<template>
  <button @click="addCounter">{{ counter }}</button>
</template>

<script>
export default {
  name: "GlobalComponent",
  // GlobalComponent 연결 시 initial-counter
  props: ['initialCounter'],
  // template: '<button @click="addCounter">{{ counter }}</button>'
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