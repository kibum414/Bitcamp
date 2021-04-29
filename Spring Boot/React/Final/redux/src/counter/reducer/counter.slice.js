// createSlice = createAction + createReducer
import { createSlice } from '@reduxjs/toolkit'

const rtkcounterReducer = createSlice({
  name: 'rtkcounterReducer',
  initialState: { number: 0 },
  reducers: {
    increase(state, action) {
      return { number: state.number + action.payload }
    },
    decrease(state, action) {
      return { number: state.number - action.payload }
    } // payload => FSA (Flux Standard Action)
  }
})

// actions, reducer : Tutorial에 나와 있는 고정 값 (fix)
// rtkcounterReducer : rtkcounterReducer 에서 지정한 name
const { actions, reducer } = rtkcounterReducer
export const { increase, decrease } = actions // { } : 구조 분해, actions : FSA
export default reducer