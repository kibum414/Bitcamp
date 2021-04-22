import React from 'react'
import { Todo } from 'todo'

const Todos = ({ todos }) => {

  return (
    <>
      <h3>Todo</h3>
      {
        todos.map(todo => (
          <Todo key={todo.id} todo={todo} />
        ))
      }
        
        
        {/* <li>
          <input type="checkbox" />
          <label>Pay Bills</label>
          <input type="text" />
          <button className="edit">Edit</button>
          <button className="delete">Delete</button>
        </li>
        {
          todos.map((todo, id) => {
            return (
              <li className="editMode" key={id}>
                <input type="checkbox" />
                <label>{todo.text}</label>
                <input type="text" value={todo.text} />
                <button className="edit" >Edit</button>
                <button className="delete" >Delete</button>
              </li>
            )
          })
        } */}
    </>
  )
}

export default Todos