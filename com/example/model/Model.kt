package com.example.model

import com.example.model.Todo

class Model {
    private val _todos: MutableList<Todo> = mutableListOf()

    fun addTodo(todo: Todo) {
        _todos.add(todo)
    }

    fun removeTodo(todo: Todo) {
        _todos.remove(todo)
    }

    fun removeTodoByIndex(index: Int) {
        _todos.removeAt(index)
    }

    fun getTodos(): List<Todo> {
        return _todos
    }

    fun countTodos(): Int {
        return _todos.count()
    }
}