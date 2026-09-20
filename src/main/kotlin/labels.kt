fun printUsers(users : List<String>) {
    users.forEach{
        if(it == "Aditya") return@forEach // THIS ACTS LIKE CONTINUE (DOES NOT RETURN FROM THE printUsers function but rather from the current lambda)
        println(it)
    }
    println("Done")
}

fun printNames(users : List<String>) {
//    THIS ONE USES CUSTOM LABEL
    users.forEach name@{
        if(it == "Aditya") return@name

        println(it)
    }

    println("Done")
}

fun main(){
    printUsers(listOf("Abhishek" , "Rahul" , "Aditya" , "Shivang" , "Mini"))
    printNames(listOf("Abhishek" , "Vikrma" , "Aditya" , "Naman" , "Mini"))
}