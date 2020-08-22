package com.example.controller

import com.example.view.View
import com.example.model.Model
import com.example.entities.Todo
import com.example.entities.Command
import com.example.controller.interfaces.Controller

class Controller : Controller() {
    override var model = Model()
    override var view  = View(model)

    override fun runApp() {
        view.displayTodoListView()

        while(shouldBeRunning) {
            view.displayTodoListCommandView()
            val command = view.getCommandFromTodoListCommandView()

            when(command) {
                Command.ADD -> {
                    var todo = view.displayAddTodoViewAndGetTodo()
                    model.addTodo(todo)
                    view.displayTodoListView()
                }
                Command.REMOVE -> {
                    var indexToRemove = view.displayRemoveTodoViewAndGetIndex()
                    model.removeTodoByIndex(indexToRemove)
                    view.displayTodoListView()
                }
                Command.QUIT -> {
                    view.displayQuitView()
                    shouldBeRunning = false
                }
                Command.INVALID -> view.displayInvalidCommandView()
            }
        }
    }
}