//inline fun greetUser(action : ()->Unit) : Unit {
//    println("Hi this is action function");
//    action();
//}
//
//inline fun noinlineexp(action1 : ()->Unit , noinline action2 : ()->String) : Unit {
//    action1();
//    action2();
//}
//
//fun checkreturn(action : ()->String) : String {
//    action();
//    println("Hello this is from inside checkreturn function")
//    return "Returned from caller"
//}
//
//fun main(){
//    greetUser(){
//        println("Hi this is lambda function")
//    }
//}

//inline fun greet(noinline action : (String) -> String){
//    println("Inside function");
//}
//
//fun check() : () -> String {
//
//}
//
//fun main() {
//    fun check(){
//    }
//}