// slice : name, state 라는 속성과 reducers 라는 기능이 합쳐진 것
import { createSlice } from '@reduxjs/toolkit'
import uuid from 'uuid/v4'

const initialState = [
  { id: 1, text: '리액트 학습', done: true }, // done : 했는지 표시하는 것(중간 줄)
  { id: 2, text: '리덕스 학습', done: true }
]

// 기능: addTodo, todos, findTodo, editTodo, delTodo
const todoReducer = createSlice({
  name: 'todoReducer',
  // initialState: initialState,
  initialState,
  reducers: {
    // Enhanced Object Literal
    addTodo(state, { payload }) { // FSA : 액션 타입 + payload(속성값)
      state.push({ id: uuid(), text: payload, done: false })
    },
    delTodo(state, { payload }) {
      return state.filter(todo => todo.id !== payload.id )
    }
  }
})

const { actions, reducer } = todoReducer
export const { addTodo, delTodo } = actions
export default reducer