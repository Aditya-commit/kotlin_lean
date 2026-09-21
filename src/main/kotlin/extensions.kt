data class Person(val firstName : String , val lastName : String)

val Person.fullName : String
get() = firstName + " " + lastName

fun main(){
    val name : String = "Aditya"

    if(name.isEmpty()){
        println("Name is empty");
    }
    else{
        println("Name is not empty")
    }

    println(name.convertToUpperCase())

    val p = Person("Aditya" , "Tomar")
    println(p.fullName)
}

fun String.convertToUpperCase() : String {
    return this@convertToUpperCase.uppercase()
}