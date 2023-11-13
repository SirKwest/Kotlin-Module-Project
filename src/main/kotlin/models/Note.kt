package models

class Note(override val title: String, val content: String): AModel(title) {
    override fun getCreationName(): String {
        return "заметку"
    }
}
