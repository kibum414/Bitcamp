import React from 'react'

const ChangeTodo = () => {

  //Edit an existing task
  const editTask = () => {
    console.log("Edit Task...");

    var listItem = this.parentNode;

    var editInput = listItem.querySelector("input[type=text]");
    var label = listItem.querySelector("label");

    var containsClass = listItem.classList.contains("editMode");


    // if class of the parent is .editMode
    if (containsClass) {
      //Switch from .editMode
      //label text become the input's value
      label.innerText = editInput.value;
    } else {
      //Switch to .editMode
      //input value becomes the labels text
      editInput.value = label.innerText;
    }
    //Toggle .editMode on the parent 
    listItem.classList.toggle("editMode");
  }

  return (
    <>
    </>
  )
}

export default ChangeTodo