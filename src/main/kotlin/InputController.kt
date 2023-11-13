import java.util.Scanner

class InputController(val input: Scanner) {
    fun getUserInputNumber(
        availableRange: IntRange,
        validation: (value: Int, availableRange: IntRange) -> Boolean
    ): Int {
        val userInput: Int
            try {
                userInput = input.nextLine().toInt()
                if (validation(userInput, availableRange)) {
                    return userInput;
                }
                println("Введенного числа нет среди допустимых команд, попробуйте ещё раз")
            } catch (e: Exception) {
                println("Пожалуйста, введите число для продолжения работы")
            }
        return -1;
    }

    fun getUserInputText(validation: (value: String) -> Boolean): String {
        var userInput: String
        while (true) {
            try {
                userInput = input.nextLine()
                if (validation(userInput)) {
                    return userInput;
                }
                println("Введено недопустимое значение, попробуйте ещё раз")
            } catch (e: Exception) {
                println("Пожалуйста, введите данные для продолжения работы")
            }
        }
    }
}
