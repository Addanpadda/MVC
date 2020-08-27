package com.example.view.interfaces

import com.example.model.Todo
import com.example.entities.Command

interface View {
    fun deliver()

    fun displayTodoListView()

    fun displayTodoListCommandView()

    fun handleInputFromTodoListCommandView()

    fun processCommandInput(): Command

    fun displayAddTodoView()

    fun displayRemoveTodoView()

    fun displayInvalidCommandView()

    fun quit()

    fun displayQuitView()
}