// createSlice = createAction + createReducer
import { createSlice } from '@reduxjs/toolkit'

const counterSlice = createSlice({
  name: 'counterSlice',
  initialState: { number: 0 },
  reducers: {
    increase: state => ({ number: state.number + 1 }),
    decrease: state => ({ number: state.number - 1 }),
    increasebyamount (state, action) {
      return ({ number: state.number + actions.payload })
    } // payload : FSA
  }
})

// actions, reducer : Tutorial에 나와 있는 값 (fix)
// counterSlice : createSlice에서 지정한 name
const { actions, reducer } = counterSlice

export const { increase, decrease } = actions // { } : 구조분해, actions : FSA

export default reducer