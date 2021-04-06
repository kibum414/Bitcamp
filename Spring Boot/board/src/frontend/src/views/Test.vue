<template>
  <div>
    <h1>뷰 테스트 페이지 입니다.</h1>
    <!-- message 거꾸로 뒤집어주는 버튼 (reverseMsg 메서드) -->
    <button v-on:click="reverseMsg">Reverse Message</button>
    <p>{{ message }}</p>
    <b>count: {{ this.$store.state.count }}</b><br>
    <b>count^2: {{ this.$store.getters.countSquare }}</b><br>
    <b>weight: {{ this.$store.getters.getWeight }}</b><br>
    <b>count^weight: {{ this.$store.getters.countWeightSquare }}</b><br>
    <b>random: {{ this.$store.getters.getRandom }}</b><br>
    <!-- count를 1씩 증가시키는 버튼 (increment() 메서드) -->
    <input type="button" @click="increment()" value="increment"/><br>
    <!-- count를 1씩 감소시키는 버튼 (decrement() 메서드) -->
    <input type="button" @click="decrement()" value="decrement"/><br>
    <!-- 랜덤으로 수를 만들어 출력하는 버튼 (randomNumber() 메서드) -->
    <input type="button" @click="randomNumber()" value="random"/><br>

    <!-- Component를 만든다는 것은 결국
         나만의 커스텀 HTML 태그를 만든다는 것을 의미한다.
         LocalComponent가 쓰는 num은
         현재 Component(Test)에서 사용하는 value와 같다. -->
    <!-- 외부 컴포넌트 :외부 컴포넌트 데이터="현재 컴포넌트 데이터" -->
    <!-- : = v-bind: -->
    <local-component :num="value"></local-component>
    <!-- value 값 1씩 증가시키는 버튼 (plus 메서드) -->
    <button v-on:click="plus">클릭</button><br>
    <!-- GlobalComponet 템플릿에 있는 내용 뿌려짐 -->
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
    // local-component 내용
    // : LocalComponent.vue에 있는 num은 value(3000)와 바인딩 됨
    'local-component': LocalComponent
  },
  methods: {
    reverseMsg: function () {
      // 문장 순서 반대로 뒤집어줌 (~ 야뷰 난 녕안)
      this.message = this.message.split('').reverse().join('')
    },
    increment: function () {
      // increment 요청을 했을 때 mutations에 가서 처리를 하겠다 명시
      this.$store.commit('increment')
      // 새로고침 하면 버튼 클릭한 횟수(count) 사라짐
      // 1분 동안은 새로고침 해도 유지 (24시 : 24h, 5초 : 5s)
      // set만 해놓고 가져오는 놈이 없어서 적용 안 됨
      this.$cookies.set('value',
          this.$store.state.count, '1m')
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value',
          this.$store.state.count, '1m')
    },
    randomNumber () {
      // dispatch를 하면 action으로 날아감 -> action 수정해야
      this.$store.dispatch('generateRandomNumber')
    },
    plus () {
      this.value++
    }
  },
  created () {
    // 쿠키를 사용함으로서 새로고침 해도 누적 count 유지됨
    // 페이지가 만들어질 때 쿠키에 저장된 value 값을 count에 저장
    this.$store.state.count = this.$cookies.get('value')
  }
}
</script>

<style scoped>

</style>