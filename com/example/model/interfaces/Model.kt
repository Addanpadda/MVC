package com.example.model.interfaces

import com.example.entities.Todo

interface Model {
    fun addTodo(todo: Todo)

    fun removeTodo(todo: Todo)

    fun removeTodoByIndex(index: Int)

    fun getTodos(): List<Todo>

    fun countTodos(): Int
}