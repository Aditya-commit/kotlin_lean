open class Parent(val nameParam : String) {
    public var name : String = nameParam;
    private var id : String = "";
    protected var protected_value : String = "";

    init {
        id = (1..100).random().toString();
    }

    fun displayId() { println(id) }
    fun greet(){
        println("Hi! How are you ?")
    }
    open fun canBeOverride(){
        print("Original member function body");
    }
}

class Child(val childName : String) : Parent(childName)  {

    fun displayName(){ println(name)}
    fun displayProtectedValue(){ println(protected_value) }
//    override fun greet(){
//        // CANNOT BE OVERRIDEN BECUASE IT IS MARKED AS FINAL
//        println("Hello! Nice to meet you")
//    }
    final override fun canBeOverride(){
//        SINCE WE ARE OVERRIDING THE PARENT CLASS MEMBER FUNCTION SO THIS FUNCTION CAN BE OVERRIDEN BY DEFAUTL FROM THE DERVIED CLASSES OF CHILD CLASS SO TO PREVENT THAT WE USE FINAL
        println("Override member function body");
    }


}

fun main(){
    val child = Child("Aditya") // IF I GIVE ANY : Child|Parent THEN I WILL BE ABLE TO ACCESS ONLY THAT CLASS METHODS

    child.displayName()
    child.displayProtectedValue()
    child.displayId()

    child.greet()
    child.canBeOverride()

}