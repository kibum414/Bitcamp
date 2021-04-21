import React from 'react'

const ReduxCounter = ({ number, onIncrease, onDecrease }) => {

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
}

export default ReduxCounter