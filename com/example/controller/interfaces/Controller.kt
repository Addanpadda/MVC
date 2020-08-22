package com.example.controller.interfaces

import com.example.view.View
import com.example.model.Model

abstract class Controller {
    abstract var model: Model
    abstract var view: View

    open var shouldBeRunning = true

    abstract fun runApp()
}