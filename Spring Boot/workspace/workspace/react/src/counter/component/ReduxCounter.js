import React from 'react'

const ReduxCounter = ({ number, onIncrease, onDecrease }) => {

  return (
    <>
      <h1>리덕스 카운터</h1>

      <div>
        <div>
          <button aria-label="+" onClick={ onIncrease }>
            +
          </button>
          <span style={{ margin: "10px" }}>{ number }</span>
          <button aria-label="-" onClick={ onDecrease }>
            -
          </button>
        </div>
      </div>
    </>
  )
}

export default ReduxCounter