import screens.ArchiveScreen
import java.lang.System.`in`
import java.util.Scanner

fun main(args: Array<String>) {
    ArchiveScreen("Список архивов", arrayListOf(), InputController(Scanner(`in`))).execute()
}