package com.example.view

import com.example.entities.Todo
import com.example.entities.Command
import com.example.model.Model
import com.example.view.interfaces.View

class View(override var model: Model) : View {
    override fun displayTodoListCommandView() {
        println("Type to: a - add; r - remove; q - quit")
        print("> ")
    }

    override fun getCommandFromTodoListCommandView(): Command {
        val command = readLine()!!
        println()

        return when(command) {
            "a" -> Command.ADD
            "r" -> Command.REMOVE
            "q" -> Command.QUIT
            else -> {
                Command.INVALID
            }
        }
    }

    override fun displayAddTodoViewAndGetTodo(): Todo {
        return getTodoFromPromtView()
    }

    fun getTodoFromPromtView(): Todo {
        var description = getInfoFromPromtView("Description: ")
        var deadline = getInfoFromPromtView("Deadline: ")

        return Todo(description, deadline)
    }

    override fun displayRemoveTodoViewAndGetIndex(): Int {
        val index = getInfoFromPromtView("Index to remove: ").toInt()
        return index
    }

    fun getInfoFromPromtView(promt: String): String {
        var info: String = ""
        while(info == "") {
            print(promt)
            info = readLine()!!
            println()
        }

        return info
    }

    override fun displayInvalidCommandView() {
        println("Not a valid command")
    }

    override fun displayTodoListView() {
        var todos = model.getTodos()

        if (model.countTodos() == 0) {
            println("You have no todos!\n")
        } else {
            println("------- TODOS -------")
            for(index in 0..todos.lastIndex) {
                println("$index) ${todos[index].description} : ${todos[index].deadline}")
            }
            println("---------------------")
        }
    }

    override fun displayQuitView() {
        println("Bye!")
    }
}