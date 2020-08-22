package com.example.model

import com.example.entities.Todo
import com.example.model.interfaces.Model

class Model : Model {
    private val todos: MutableList<Todo> = mutableListOf()

    override fun addTodo(todo: Todo) {
        todos.add(todo)
    }

    override fun removeTodo(todo: Todo) {
        todos.remove(todo)
    }

    override fun removeTodoByIndex(index: Int) {
        todos.removeAt(index)
    }

    override fun getTodos(): List<Todo> {
        return todos
    }

    override fun countTodos(): Int {
        return todos.count()
    }
}