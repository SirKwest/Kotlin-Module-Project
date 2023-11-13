package screens

import InputController
import models.AModel

abstract class AScreen<T: AModel>(
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

    open fun creation() {}
    open fun selection(position: Int) {}
    fun execute () {
        while (true) {
            showMenu()
            val command = inputController.getUserInputNumber(
                0..listOfElements.size + 1,
                validation = { number, numberRange -> number in numberRange }
            )
            when (command) {
                0 -> creation()
                in 1 until listOfElements.size + 1 -> selection(command - 1)
                listOfElements.size + 1 -> break
                else -> continue
            }
        }
    }
}
