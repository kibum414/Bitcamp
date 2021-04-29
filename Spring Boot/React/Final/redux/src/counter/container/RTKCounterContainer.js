import React from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { RTKCounter } from '..'
import { increase, decrease } from '../reducer/counter.slice'

const RTKCounterContainer = () => {
  // rtkcounterReducer : rtkcounterReducer 에서 지정한 name
  const number = useSelector(state => state.rtkcounterReducer.number)
  const dispatch = useDispatch()

  return (
    <>
      <RTKCounter
        number={ number }
        onIncrease={() => dispatch(increase(3))}
        onDecrease={() => dispatch(decrease(1))} />
    </>
  )
}

export default RTKCounterContainer