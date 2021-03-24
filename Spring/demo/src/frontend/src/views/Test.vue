<template>
  <div>
    <h1>뷰 테스트 페이지 입니다.</h1>
    <!-- 글자 거꾸로 뒤집는 버튼 -->
    <button v-on:click="reverseMsg">Reverse Message</button>
    <p>{{ message }}</p>
    <!-- increment 버튼 클릭 횟수 출력 -->
    <b>count: {{ this.$store.state.count }}</b><br>
    <!-- increment 버튼 클릭 횟수 제곱수 출력 -->
    <b>count^2: {{ this.$store.getters.countSquare }}</b><br>
    <b>weight: {{ this.$store.getters.getWeight }}</b><br>
    <!-- decrement 버튼 클릭 시 count의 weight 제곱수 출력 -->
    <b>count^weight: {{ this.$store.getters.countWeightSquare }}</b><br>
    <b>random: {{ this.$store.getters.getRandom }}</b><br>
    <input type="button" @click="increment()" value="increment"/><br>
    <input type="button" @click="decrement()" value="decrement"/><br>
    <input type="button" @click="randomNumber()" value="random"/><br>

    <!-- Component를 만든다는 것은 결국
         나만의 커스텀 HTML 태그를 만든다는 것을 의미한다.
         LocalComponent가 쓰는 num은
         현재 Component(Test)에서 사용하는 value와 같다. -->
    <!-- => 앞에가 가져온 거 : 뒤에가 여기서 쓰는 거 -->
    <!-- <local-component v-bind:num="value"></local-component> 와 같음 -->
    <local-component :num="value"></local-component>
    <button v-on:click="plus">클릭</button><br>
    <global-component :initial-counter="counter"></global-component>
  </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

import LocalComponent from "@/components/LocalComponent";
import GlobalComponent from "@/components/GlobalComponent";

// Global Component는 등록을 해주어야 함
Vue.component(GlobalComponent.name, GlobalComponent)
Vue.use(cookies)

export default {
  name: "Test",
  data () {
    return {
      message: "안녕 난 뷰야 ~",
      // global-component의 counter
      counter: 7000,
      // local-component의 value
      value: 3000
    }
  },
  components: {
    // local-component 내용 : LocalComponent.vue에 있는 num은 value와 바인딩이 돼서
    'local-component': LocalComponent
  },
  methods: {
    reverseMsg: function () {
      // 문장 순서 반대로 출력 (~ 야뷰 난 녕안)
      this.message = this.message.split('').reverse().join('')
    },
    increment: function () {
      // increment 요청을 했을 때 mutations에 가서 처리를 하겠다 명시
      this.$store.commit('increment')
      // 현재는 새로고침 하면 버튼 클릭한 횟수(count) 사라짐
      // 1분 동안은 새로고침 해도 유지 (24시 : 24h, 5초 : 5s)
      // set만 해놓고 가져오는 놈이 없어서 적용 안 됨
      this.$cookies.set('value', this.$store.state.count, '1m')
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value', this.$store.state.count, '1m')
    },
    // dispatch를 하면 action으로 날아감 -> action 수정
    randomNumber () {
      this.$store.dispatch('generateRandomNumber')
    },
    plus () {
      this.value++
    }
  },
  created() {
    // 쿠키를 사용함으로서 새로고침 해도 누적 count 유지됨
    this.$store.state.count = this.$cookies.get('value')
  }
}
</script>

<style scoped>

</style>