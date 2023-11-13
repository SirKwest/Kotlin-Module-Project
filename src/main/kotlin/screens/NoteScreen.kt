package screens

import InputController
import models.Note

class NoteScreen(
    override val title: String,
    override val listOfElements: ArrayList<Note>,
    inputController: InputController
) : AScreen<Note>(title, listOfElements, inputController) {

    override fun showCreationLine() {
        println("0. Создать заметку")
    }

    override fun showExitingLine() {
        println("${listOfElements.size + 1}. Назад")
    }

    override fun creation() {
        println("Введите название:")
        val noteName = inputController.getUserInputText { value -> value.isNotBlank() }
        println("Введите содержимое:")
        val noteContent = inputController.getUserInputText { value -> value.isNotBlank() }
        listOfElements.add(Note(noteName, noteContent))
    }

    override fun selection(position: Int) {
        println("=================")
        println("Содержимое заметки:")
        println(listOfElements[position].content)
        println("=================")
    }
}
