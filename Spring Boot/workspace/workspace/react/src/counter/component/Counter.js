import React, { useState } from 'react'

const Counter = () => {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1>카운터</h1>

      <div>
        <div>
          <button aria-label="+" onClick={() => { setCount(count + 1) }}>
            +
          </button>
          <span style={{margin: '30%'}}>{count}</span>
          <button aria-label="-" onClick={() => { setCount(count - 1) }}>
            -
          </button>
        </div>
      </div>
    </>
  )
}

export default Counter