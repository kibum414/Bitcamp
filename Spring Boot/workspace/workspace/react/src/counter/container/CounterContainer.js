import React, { useCallback } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { increase, decrease } from 'counter/reducer/Counter.reducer'
import HomeNav from 'common/component/HomeNav'
import { ReduxCounter } from 'counter'
import HomeFooter from 'common/component/HomeFooter'

const CounterContainer = () => {
  const number = useSelector(state => state.counterReducer.number)
  const dispatch = useDispatch()
  const onIncrease = useCallback(() => dispatch(increase()), [dispatch])
  const onDecrease = useCallback(() => dispatch(decrease()), [dispatch])

  return (
    <>
      <HomeNav />
      <ReduxCounter number={number} onIncrease={onIncrease} onDecrease={onDecrease} />
      <HomeFooter />
    </>
  )
}

export default CounterContainer