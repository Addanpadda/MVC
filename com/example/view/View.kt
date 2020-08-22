package com.example.view

import com.example.model.*

class View {
    var model = Model()

    fun displayTodoListCommandView(): Int {
        println("Type to: a - add; r - remove; q - quit")
        print("> ")
        val command = readLine()!!
        println()

        when(command) {
            "a" -> return displayAddTodoView()
            "r" -> return displayRemoveTodoView()
            "q" -> return -1
            else -> {
                println("Not a valid command")
                return displayTodoListCommandView()
            }
        }
    }

    fun displayAddTodoView(): Int {
        val todo = getTodoFromPromtView()
        model.addTodo(todo)
        return 0
    }

    fun getTodoFromPromtView(): Todo {
        var description = getInfoFromPromtView("Description: ")
        var deadline = getInfoFromPromtView("Deadline: ")

        return Todo(description, deadline)
    }

    fun displayRemoveTodoView(): Int {
        val index = getInfoFromPromtView("Index to remove: ").toInt()
        model.removeTodoByIndex(index)
        return 0
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

    fun displayTodos() {
        var todos = model.getTodos()

        if (model.countTodos() == 0) {
            println("You have no todos!\n")
        } else {
            println("----- TODOS -----")
            for(index in 0..todos.lastIndex) {
                println("$index) ${todos[index].description} : ${todos[index].deadline}")
            }
            println("-----------------")
        }
    }
}

fun main(args: Array<String>) {
    var view = View()
    var shouldBeRunning = true

    while(shouldBeRunning) {
        view.displayTodos()
        val exitCode = view.displayTodoListCommandView()
        if (exitCode == -1) {
            shouldBeRunning = false
            println("Bye!")
        }
    }
}