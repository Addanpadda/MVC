package com.example.controller.interfaces

import com.example.model.Todo
import com.example.view.ViewImpl

abstract class Controller {
    abstract var view: ViewImpl

    open var shouldBeRunning = true


    abstract fun addTodo(todo: Todo)

    abstract fun removeTodo(todo: Todo)

    abstract fun removeTodoByIndex(index: Int)

    abstract fun getTodos(): List<Todo>

    abstract fun countTodos(): Int
}