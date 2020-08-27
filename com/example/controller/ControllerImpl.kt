package com.example.controller

import com.example.view.ViewImpl
import com.example.model.Todo
import com.example.entities.Command
import com.example.controller.interfaces.Controller

class ControllerImpl : Controller() {
    override var view = ViewImpl(::addTodo, ::removeTodoByIndex, ::getTodos)
    private val todos: MutableList<Todo> = mutableListOf()

    init {
        view.deliver()
    }

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