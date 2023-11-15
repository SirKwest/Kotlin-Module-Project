package screens

import InputController
import models.IModel

abstract class AScreen<T: IModel>(
    open val title: String,
    open val listOfElements: ArrayList<T>,
    open val inputController: InputController)
{
    abstract fun showCreationLine()
    open fun showExitingLine() {
        println("${listOfElements.size + 1}. Выход")
    }
    private fun showMenu() {
        println()
        println(title)
        println()
        showCreationLine()
        listOfElements.forEachIndexed { index, s -> println("${index + 1}. ${s.title}") }
        showExitingLine()
    }

    open fun create() {}
    open fun select(position: Int) {}
    fun execute () {
        while (true) {
            showMenu()
            val command = inputController.getUserInputNumber(
                validation = { number -> number in 0..listOfElements.size + 1 }
            )
            when (command) {
                0 -> create()
                in 1 until listOfElements.size + 1 -> select(command - 1)
                listOfElements.size + 1 -> break
                else -> continue
            }
        }
    }
}
