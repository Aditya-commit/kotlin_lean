fun main(){

    var count = 0

    val incrementer = {

        // SINCE THIS LAMBDA FUNCTION IS ACCESSING THE VARIABLE THAT IS OUTSIDE THIS FUNCTION SO THIS LAMBDA IS ACTUALLY A CLOSURE
        count++ // HERE count IS ACTUALLY USING THE REFERENCE OF THE OUTER count
        println(count)
    }

    incrementer()
    incrementer()
    incrementer()
    incrementer()


    // EXAMPLE 2
    val instance1 = testVanishedOuterFunc();
    val instance2 = testVanishedOuterFunc();

    println(instance1());
    println(instance1());
    println(instance1());

    println(instance2())
    println(instance2())
    println(instance2())

}

fun testVanishedOuterFunc() : () -> String {

    var times = 1

    return fun() : String{
        times++
        return "Hi ${times}"
    }
}