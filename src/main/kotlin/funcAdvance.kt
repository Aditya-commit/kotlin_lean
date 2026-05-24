fun log(
    level: Int = 0,
    code : Int = 1,
    action : () -> Unit,
){
    println(level)
    println(code)
    action()

    println("This is the end of the function");
}
fun main(){

    log(10) { println("Hi this is action function")}
    log(code=20 , action={ println("Hi this is also the action function") })
    log { println("this is the last action function") }
}