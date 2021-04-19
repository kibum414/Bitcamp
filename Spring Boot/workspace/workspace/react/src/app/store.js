import { configureStore } from '@reduxjs/toolkit'
import counterReducer from 'board/service/Counter.slice'

export default configureStore({
  reducer: {
    counter: counterReducer
  },
})