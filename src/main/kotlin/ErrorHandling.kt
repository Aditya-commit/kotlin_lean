fun main() {

    println("Please enter the number")
    val input = readln()

    try {
        val inputAsInteger = input.toInt()

        println("The number is $inputAsInteger")
    }
    catch (e : NumberFormatException) {
        println(e)
        println("The number is not a number")
    }
}