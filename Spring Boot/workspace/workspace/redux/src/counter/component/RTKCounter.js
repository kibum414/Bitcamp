import React from 'react'

const RTKCounter = React.memo(({ number, onIncrease, onDecrease }) => {
  console.log("number : ", number)
  console.log("onIncrease : ", onIncrease)
  console.log("onDecrease : ", onDecrease)

  return (
    <div style={{ display: "inline-block" }}>
      <h1>Redux Toolkit Counter</h1>

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

export default RTKCounter