import React, { useState } from 'react';
import { useDispatch } from 'react-redux';

const Add = ({ addTodo }) => {

  // //Add a new task
  // const addTask = () => {
  //   console.log("Add Task...");
  //   // //Create a new list item with the text from the #new-task:
  //   // const listItem = createNewTaskElement(taskInput.value);
  //   // //Append listItem to incompleteTaskHolder
  //   // incompleteTasksHolder.appendChild(listItem);
  //   // bindTaskEvents(listItem, taskCompleted);
  //   const taskInput = document.getElementById("new-task")
  //   taskInput.value = "";
  // }

  const [input, setInput] = useState('')

  const dispatch = useDispatch()

  const addSubmit = e => {
    e.preventDefault()
    
    console.log(input)
    dispatch(addTodo(input))
  }

  return (
    <>
      <form onSubmit={addSubmit}>
        <p>
          <label htmlFor="new-task">Add Item</label>
          <input id="new-task" type="text" onChange={e => setInput(e.target.value)} />
          <button type="submit">Add</button>
        </p>
      </form>
    </>
  )
}

export default Add