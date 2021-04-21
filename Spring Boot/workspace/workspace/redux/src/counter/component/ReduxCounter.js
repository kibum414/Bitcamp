import React from 'react'

const ReduxCounter = React.memo(({ number, onIncrease, onDecrease }) => {
// memo : 이전의 값 저장하기 위한 것 (number의 값)
  
  return (
    <div style={{ display: "inline-block" }}>
      <h1>Redux Counter</h1>

      <button aria-label="-" onClick={ onDecrease }>
        -
      </button>
      <span style={{ margin: "10px" }}>
        { number }
      </span>
      <button aria-label="+" onClick={ onIncrease }>
        +
      </button>
    </div>
  )
})

export default ReduxCounter