package com.example.view

import com.example.model.Todo
import com.example.entities.Command
import com.example.view.interfaces.View


class ViewImpl(var addTodoCallback: (todo: Todo) -> Unit, var removeTodoCallback: (index: Int) -> Unit, var getTodosCallback: () -> List<Todo>) : View {
    var isRunning = true

    override fun deliver() {
        while(isRunning) {
            displayTodoListView()
            displayTodoListCommandView()
        }
    }

    override fun displayTodoListView() {
        var todos = getTodosCallback()

        if (todos.count() == 0) {
            println("You have no todos!\n")
        } else {
            println("------- TODOS -------")
            for(index in 0..todos.lastIndex) {
                println("$index) ${todos[index].description} : ${todos[index].deadline}")
            }
            println("---------------------")
        }
    }

    override fun displayTodoListCommandView() {
        println("Type to: a - add; r - remove; q - quit")
        print("> ")
        handleInputFromTodoListCommandView()
    }

    override fun handleInputFromTodoListCommandView() {
        var command = processCommandInput()

        when(command) {
            Command.ADD -> displayAddTodoView()
            Command.REMOVE -> displayRemoveTodoView()
            Command.QUIT -> quit()
            Command.INVALID -> displayInvalidCommandView()
        }
    }

    override fun processCommandInput(): Command {
        var command: Command = when(readLine()!!) {
            "a" -> Command.ADD
            "r" -> Command.REMOVE
            "q" -> Command.QUIT
            else -> {
                Command.INVALID
            }
        }
        println()

        return command
    }

    override fun displayAddTodoView() {
        addTodoCallback(getTodoFromPromtView())
    }

    fun getTodoFromPromtView(): Todo {
        var description = getInfoFromPromtView("Description: ")
        var deadline = getInfoFromPromtView("Deadline: ")

        return Todo(description, deadline)
    }

    override fun displayRemoveTodoView() {
        removeTodoCallback(getInfoFromPromtView("Index to remove: ").toInt())
    }

    override fun displayInvalidCommandView() {
        println("Not a valid command")
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

    override fun quit() {
        displayQuitView()
        isRunning = false
    }

    override fun displayQuitView() {
        println("Bye!")
    }
}