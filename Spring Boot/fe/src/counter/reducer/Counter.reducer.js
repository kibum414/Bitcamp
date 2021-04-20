import { createAction, handleAction } from 'redux-actions'

const INCREASE = 'counter/INCREASE'
const DECREASE = 'counter/DECREASE'

const increase = createAction(INCREASE) // 액션 객체 (리듀서의 파라미터)
const decrease = createAction(DECREASE)

const initialState = { number: 0 }

const counterReducer = handleAction({
  INCREASE: (state, action) => ({}),
  DECREASE: (state, action) => ({})
})