/*
    NAME: ERTUGRUL SAHIN , JOHN OLAYENI , LEVI MAXWELL
    STUDENT NUMBER : A00270022, A00260853 , A00263436
    DESCRIPTION : The todo list application receives an input from the user. We add the value I get from the user to the listview. 
    The user can see this value instantly as a list. If he wants, he can delete the value he added.
 */


package com.example.todolistapp

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.todolistapp.adapter.TodoAdapter

class MainActivity : AppCompatActivity() {
    // We have created an arraylist that we will use to list in listview. In Arraylist type Todo model
    var todoList= ArrayList<Todo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // we called editText and button and defined new variable
        var editText:EditText=findViewById(R.id.getText)
        var addButton:Button=findViewById(R.id.addButton)
        // if the button clicked works that method
        addButton.setOnClickListener {
            // We add the variable we received from the user to the list
            todoList.add(Todo(editText.text.toString()))
            // we cleaned editText after add item in the list
            editText.text.clear()
            // edit text was left open, the code needed to close it
            val inputManager: InputMethodManager = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }

        // We defined the listview we created in the layout here and assigned it to the new value.
        var todoListView:ListView?=findViewById(R.id.todoList)
        // Since we want to customize the item layout in Listview, we first defined the adapter
        var adapter=TodoAdapter(this,todoList)
        // We connected listview to adapter
        todoListView?.adapter=adapter
        // we used it to update the information on the screen
        adapter.notifyDataSetChanged()

    }
}
