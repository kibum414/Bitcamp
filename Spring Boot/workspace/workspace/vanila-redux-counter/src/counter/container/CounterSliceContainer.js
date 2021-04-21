import React, { useCallback } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { increase, decrease } from 'counter/reducer/counter.slice'
import { CounterSlice } from 'counter'

const CounterSliceContainer = () => {
  const number = useSelector(state => state.counterSlice.number) // createSlice의 name
  const dispatch = useDispatch()
  const onIncrease = useCallback(() => dispatch(increase()), [dispatch])
  const onDecrease = useCallback(() => dispatch(decrease()), [dispatch])

  return (
    <>
      <CounterSlice number={number} onIncrease={onIncrease} onDecrease={onDecrease} />
    </>
  )
}

export default CounterSliceContainer