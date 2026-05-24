fun main(){

    val total = ::sum; // WE CAN STORE FUNCTIONS IN A VARIABLE LIKE THIS AS WELL

    println(total(2 , 4))

    println(calculator(39 , 44 , total)) // one way (we are using the variable that stored the function (sum))
    println(calculator(43 , 33 , ::sum)) // another way
}

fun sum (a : Int , b : Int) : Int = a + b

fun calculator(a : Int , b : Int , operation : (Int , Int) -> Int) : Int { // HOC
//    THIS HOC FUNCTION IS ACCEPTING A FUNCTION

    // WE CAN ALSO CREATE A HOC FUNCTION THAT RETURNS THE FUNCTION
    return operation(a, b)
}