import kotlin.reflect.KType
import kotlin.reflect.typeOf

fun main() {

    println("Please enter your phone number")
    var input = readln()
    val inputAsInteger = input.toIntOrNull()

    if(inputAsInteger == null) {
        println("Please enter a valid phone number")
    }
    else{
        print(inputAsInteger)
    }


    fun sum(a : Int , b : Int) : Int {
        return a + b
    }

    val result = sum(10 , 33)
    println("The result is $result")



    fun greet(msg : String = "Hi how are you ??") {
        println(msg)
    }

    println("Please enter the greeting or press enter to skip")
    val userInput = readln()

//    if(userInput == ""){
//        greet()
//    }
//    else{
//        greet(userInput)
//    }

//    using when
    when {
        userInput == "" -> greet()
        else -> greet(userInput)
    }
}