import React, { useCallback } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { increase, decrease } from 'counter/reducer/counter.reducer'
import { ReduxCounter } from 'counter'

const CounterContainer = () => {
  const number = useSelector(state => state.counterReducer.number)
  const dispatch = useDispatch()
  const onIncrease = useCallback(() => dispatch(increase(7)), [dispatch])
  const onDecrease = useCallback(() => dispatch(decrease(3)), [dispatch])

  return (
    <>
      <ReduxCounter number={number} onIncrease={onIncrease} onDecrease={onDecrease} />
    </>
  )
}

export default CounterContainer