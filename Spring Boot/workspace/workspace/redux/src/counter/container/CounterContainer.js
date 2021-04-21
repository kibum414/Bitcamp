import React, { useCallback } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { ReduxCounter } from '..'
import { increase, decrease } from '../reducer/Counter.reducer'

const CounterContainer = () => {
  const number = useSelector(state => state.counterReducer.number)
  const dispatch = useDispatch()
  const onIncrease = useCallback(() => dispatch(increase()), [dispatch])
  const onDecrease = useCallback(() => dispatch(decrease()), [dispatch])

  return (
    <>
      <ReduxCounter
        number={number}
        onIncrease={onIncrease}
        onDecrease={onDecrease}
      />
    </>
  )
}

export default CounterContainer