import React from 'react'

const ReduxCounter = React.memo(({ number, onIncrease, onDecrease }) => {

  return (
    <>
      <h1>리덕스 카운터</h1>

      <div>
        <div>
          <button aria-label="+" onClick={ onIncrease }>
            +
          </button>
          <span style={{ margin: "30%" }}>{ number }</span>
          <button aria-label="-" onClick={ onDecrease }>
            -
          </button>
        </div>
      </div>
    </>
  )
})

export default ReduxCounter