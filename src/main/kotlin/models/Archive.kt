package models

class Archive(override val title: String): IModel {
    val containedNotes: ArrayList<Note> = arrayListOf()
}
