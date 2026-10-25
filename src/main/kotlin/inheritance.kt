open class Base {
    init {
        println("---- Creating object of Base class -----")
    }
    open fun greet(){
        println("Good Morning")
    }
}

open class Derived : Base() {
    init {
        println("---- Creating object of Derived class -----")
    }
    init { println("Can use multiple init blocks") }
    override final fun greet(){
        println("Updated greet function from derived class") // USING final WITH override PREVENTS THE CHILD CLASSES OF DERIVED CLASS TO OVERRIDE THIS MEMBER FUNCTION 
    }
}


class Derived1 : Derived(){
	fun passCheck(){
	super.greet() // super is used to acess parent class member functions or members
        println("Password matched!");
    }
}

fun main(){
    println("----- Program Started ------");
	
    val d = Derived()
    d.greet();
    
    println()
    
    val d1 = Derived1();
    d1.passCheck()
}

// WE DON'T NEED A NEW KEYWORD TO CREATE AN OBJECT OF CLASS IN KOTLIN
// IF WE DO NOT USE OPEN FOR A CLASS THEN THAT CLASS IS CONSIDERED AS FINAL AND CANNOT BE INHERITED BY ANY OTHER CLASS
// IF WE WANT THE MEMBER/MEMBER FUNCTION OF BASE CLASS TO BE OVERRIDDEN BY THE DERIVED CLASS THEN WE HAVE TO MARK THAT WITH open KEYWORD
