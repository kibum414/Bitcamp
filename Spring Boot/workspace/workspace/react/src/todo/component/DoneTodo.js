import React from 'react'

const Completed = () => {

  //Mark a task as complete
  const taskCompleted = () => {
    console.log("Task Complete...");
    //When the Checkbox is checked 
    //Append the task list item to the #completed-tasks ul
    //var listItem = this.parentNode;
    //completedTasksHolder.appendChild(listItem);
    //bindTaskEvents(listItem, taskIncomplete);
  }


  //Mark a task as incomplete
  const taskIncomplete = () => {
    console.log("Task Incomplete...");
    //When the checkbox is unchecked appendTo #incomplete-tasks
    //var listItem = this.parentNode;
    //incompleteTasksHolder.appendChild(listItem);
    //bindTaskEvents(listItem, taskCompleted);
  }

  //Delete an existing task
  const deleteTask = () => {
    console.log("Delete Task...");
    //Remove the parent list item from the ul
    // var listItem = this.parentNode;
    // var ul = listItem.parentNode;

    // ul.removeChild(listItem);
  }


  const bindTaskEvents = (taskListItem, checkBoxEventHandler) => {
    console.log("Bind List item events");
    // select listitems chidlren
    var checkBox = taskListItem.querySelector('input[type="checkbox"]');
    var editButton = taskListItem.querySelector("button.edit");
    var deleteButton = taskListItem.querySelector("button.delete");
    //bind editTask to edit button
    //editButton.onclick = editTask;
    //bind deleteTask to delete button
    //deleteButton.onclick = deleteTask;
    //bind checkBoxEventHandler to checkbox
    checkBox.onchange = checkBoxEventHandler;

  }

  const incompleteTasksHolderLoop = () => {
    //cycle over incompleteTaskHolder ul list items
    // let i = 0
    // for (; i < incompleteTasksHolder.children.length; i++) {
    //   //bind events to list item's children (taskCompleted)	
    //   bindTaskEvents(incompleteTasksHolder.children[i], taskCompleted);
    // }
  }

  const completedTasksHolderLoop = () => {
    //cycle over completedTaskHolder ul list items
    // let i = 0
    // for (; i < completedTasksHolder.children.length; i++) {
    //   //bind events to list item's children (taskCompleted)	
    //   bindTaskEvents(completedTasksHolder.children[i], taskIncomplete);
    // }
  }

  return (
    <>
      <h3>Completed</h3>
      <ul id="completed-tasks">
        <li>
          <input type="checkbox" checked="" />
          <label>See the Doctor</label>
          <input type="text" />
          <button className="edit" onClick={taskCompleted}>Edit</button>
          <button className="delete" onClick={deleteTask}>Delete</button>
        </li>
      </ul>
    </>
  )
}

export default Completed