package models

abstract class AModel(open val title: String) {
    abstract fun getCreationName(): String
}