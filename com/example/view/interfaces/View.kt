package com.example.view.interfaces

import com.example.entities.Todo
import com.example.entities.Command
import com.example.model.Model

interface View {
    var model: Model

    fun displayTodoListCommandView()

    fun getCommandFromTodoListCommandView(): Command

    fun displayAddTodoViewAndGetTodo(): Todo

    fun displayRemoveTodoViewAndGetIndex(): Int

    fun displayInvalidCommandView()

    fun displayTodoListView()

    fun displayQuitView()
}