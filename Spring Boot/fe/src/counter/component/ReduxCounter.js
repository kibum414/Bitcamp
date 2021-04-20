import React from 'react'

const ReduxCounter = React.memo(({ number, onIncrease, onDecrease }) => {
// memo : 이전의 값 저장하기 위한 것 (number의 값)
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
})

export default ReduxCounter