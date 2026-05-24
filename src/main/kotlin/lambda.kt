fun main(){

    val add = { a : Int , b : Int -> a+b }; // THIS IS A LAMBDA FUNCTION

    println(add(1,2))

    val doubleSum : (Int) -> Int = { it + it }; // HERE it MEANS THE SINGLE ARGUMENT (IF WE ARE USING ONLY ONE ARGUMENT THEN WE CAN USE it INSTEAD OF EXPLICITLY NAMING THE ARGUMENT)

    val printName : (String) -> Unit = {
        println(it);
    }

    println("Aditya Singh Tomar");

    val printMultiply : (Int , Int) -> Int = {a , b -> a * b}

    println(printMultiply(4 , 5))


    // NON-LOCAL RETURN
    fun test(){

        listOf<Int>(1,2,3,4,5).map {
            if(it == 3){
                return
            }

            println(it);
        }

        println("Done")
    }

    test()
}