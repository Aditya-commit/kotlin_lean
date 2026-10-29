class Person1(val name : String , val age : Int){
    
    constructor(name : String?) : this(name ?: "Guest" , 1){}
    
    fun printUserDetails(){
        println("""Name - $name
Age - $age""")
    }
}


fun main(){
    
    val p = Person1("Aditya" , 25)
    p.printUserDetails()
    
}


// BETTER APPROACH IS TO USE DEFAULT VALUE IN PRIMARY CONSTURCTOR AS IT MAKE THE OBJECT CREATION MORE FLEXIBLE (CURRENTLY WITH THIS APPROACH WE CAN'T DO val p = Person(age=33) , THIS WILL TRHOW ERROR , BUT IF WE REMOVE SECONDARY CONSTRUCTOR AND USE DEFAULT VALUES IN class Person(val name : String = "Guest" , val age : Int = 23){} , WE CAN MAKE CONSTRUCTOR IN ANY WAY , val p = Person() , Person("Aditya") , Person(age=44) , Person("New" , 34)
