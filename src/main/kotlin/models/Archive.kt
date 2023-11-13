package models

class Archive(override val title: String): AModel(title) {
    val containedNotes: ArrayList<Note> = arrayListOf()

    override fun getCreationName(): String  {
        return "архив"
    }
}
