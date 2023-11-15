package screens

import InputController
import models.Archive

class ArchiveScreen(
    override val title: String,
    override val listOfElements: ArrayList<Archive>,
    override val inputController: InputController,
) : AScreen<Archive>(title, listOfElements, inputController) {

    override fun showCreationLine() {
        println("0. Создать архив")
    }

    override fun create() {
        println("Введите название архива")
        listOfElements.add(Archive(inputController.getUserInputText { value -> value.isNotBlank() }))
    }

    override fun select(position: Int) {
        NoteScreen("Список заметок", listOfElements[position].containedNotes, inputController).execute()
    }
}
