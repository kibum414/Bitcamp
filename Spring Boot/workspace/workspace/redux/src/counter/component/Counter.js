import React, { useState } from 'react'

const Counter = () => {
  const [count, setCount] = useState(0)

  return (
    <div style={{ display: "inline-block" }}>
      <h1>Counter</h1>

      <button aria-label="-" onClick={() => { setCount(count - 1) }}>
        -
      </button>
      <span style={{ margin: "10px" }}>
        { count }
      </span>
      <button aria-label="+" onClick={() => { setCount(count + 1) }}>
        +
      </button>
    </div>
  )
}

export default Counter