import packages.printName
import packages.printAge

fun main(){

    println("Please enter your name :")
    val input = readlnOrNull()

    if(input !== null){
        if(input.trim() !== ""){
            printName(input);
        }
        else{
            println("Name cannot be empty")
        }
    }
    else{
        println("Please enter the name of the input")
    }

    printAge(23);
}