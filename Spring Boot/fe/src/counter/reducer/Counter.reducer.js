// store : 객체
import { createAction, handleAction } from 'redux-actions'

// action : 변화
const INCREASE = 'counter/INCREASE' // type 정의. String 값
const DECREASE = 'counter/DECREASE'

export const increase = createAction(INCREASE) // 액션 객체 (리듀서의 파라미터)
export const decrease = createAction(DECREASE)

// state : 보관. JSON 객체
const initialState = { number: 0 } // 키 : 값 => 키는 바뀌지 않음, 값만 바뀜

// reducer : 변화
const counterReducer = handleAction({ // 내부 리듀서는 아직 작동하지 않고 있음. 이벤트가 주어지기 전에는 선언만 되어 있음
  [INCREASE] : (state, action) => ({ number : state.number + 1 }), // state : 전역 state
  [DECREASE] : (state, action) => ({ number : state.number - 1 }) // [] : store, IN,DE : reducer
}, initialState) // initialState 에 바뀌어진 값이 저장
// -> 데코레이션 패턴 (state: 빵, INCREASE, DECREASE: 데코 선택)

export default counterReducer