import { Header, Footer } from 'common';
import React from 'react'
import { useSelector } from 'react-redux';
import { AddTodo, DoneTodo, Todos } from 'todo';
import 'todo/style/Todo.css'
import { addTodo } from 'todo/reducer/todo.reducer'

const TodoApp = () => {

  //Problem: user interaction doesn't provide desired results
  //Solution: add interactivity so the user can manage daily tasks.

  var taskInput = document.getElementById("new-task"); // new-task
  var addButton = document.getElementsByTagName("button")[0];//first button
  var incompleteTasksHolder = document.getElementById("incomplete-tasks"); //incomplete-tasks
  var completedTasksHolder = document.getElementById("completed-tasks"); //completed-tasks

  //New Task List item

  const createNewTaskElement = function (taskString) {
    // create List Item
    const listItem = document.createElement("li");
    // input checkbox
    const checkBox = document.createElement("input");
    // label
    const label = document.createElement("label");
    // input (text)
    const editInput = document.createElement("input");
    // button.edit
    const editButton = document.createElement("button");
    // button.delete
    const deleteButton = document.createElement("button");

    //Each element needs modified 

    checkBox.type = "checkBox";
    editInput.type = "text";

    editButton.innerText = "Edit";
    editButton.className = "edit";
    deleteButton.innerText = "Delete";
    deleteButton.className = "delete";

    label.innerText = taskString;

    // Each element needs appending
    listItem.appendChild(checkBox);
    listItem.appendChild(label);
    listItem.appendChild(editInput);
    listItem.appendChild(editButton);
    listItem.appendChild(deleteButton);

    return listItem;
  }

  const todos = useSelector(state => state.todoReducer)
  
  return (
    <div className="todo">
      <Header />
      <div className="todo-container">
        <AddTodo addTodo={addTodo} />
        <Todos todos={todos} />
        <DoneTodo />
      </div>
      <Footer />
    </div>
  )
}

export default TodoApp