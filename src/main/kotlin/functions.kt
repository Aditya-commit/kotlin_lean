fun main(){

    println("Please enter your name")
    val name = readLine() ?: ""

    if(name.isEmpty()){
        println("Cannot submit empty name")
    }
//    HERE WE ARE USING INFIX NOTATION
    else if(name isExceedingMaxLength 10){
        println("Name cannot contain more than 10 characters.")
    }
    else{
        println("Your form has been submitted successfully")
    }


    val itemsList = asList(1 , 2 , 3 , 23 , 55)
    println(itemsList)
}


// BUILDING AN EXTENSION FUNCTION
fun String.isEmpty() : Boolean {
    return this@isEmpty.trim() == ""
}

infix fun String.isExceedingMaxLength(size : Int) : Boolean {
    return this@isExceedingMaxLength.count() > size
}

// LIKE THIS WE CAN PASS ANY NUMBER OF ARGUMENTS
fun <T> asList(vararg items : T) :  MutableList<T>{

    val list = mutableListOf<T>()

    for(item in items){
        list.add(item)
    }

    return list
}