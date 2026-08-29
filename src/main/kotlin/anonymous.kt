// ANONYMOUS FUNCTION HAVE THEIR OWN LOCAL RETURN SCOPE

fun main(){

    val anonymous = fun(a : Int , b : Int) : Int = a+b

    println(anonymous(24 , 5))

    //    OWN LOCAL RETURN SCOPE EXAMPLE
    fun test(){
        listOf<Int>(12 , 3 , 4 , 6 , 71).map(fun(x : Int) {
            if(x == 4) return
            println(x)
        })
        println("Done the map loop");
    }

    test()
}