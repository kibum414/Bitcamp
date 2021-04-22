import React from 'react'

const Todo = ({ todo }) => {

  return (
    <>
      <ul id="incomplete-tasks">
        <li className="editMode">
          <input type="checkbox" />
          <label>{todo.text}</label>
          <input type="text" value={todo.text} />
          <button className="edit" >Edit</button>
          <button className="delete" >Delete</button>
        </li>
      </ul>
    </>
  )
}

export default Todo