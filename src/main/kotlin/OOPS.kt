class PrimaryConstructor(val name : String , val age : Int ){

    fun displayName(){
        println("Name = $name")
    }

    fun displayAge(){
        println("Age $age")
    }
}

class SecondaryConstructor(val name : String , val age : Int , val school : String ){

    constructor(name : String , age : Int) : this(name, age, school = "S.T. Thomas College"){
        println("Here we are setting the default value of school")
    }

    fun displayName(){ println("Name = $name") }
    fun displayAge(){ println("Age $age") }
    fun displaySchool(){ println("School $school") }
}

class SkipPrimaryConstructor(){
//  THIS WILL MAKE THE OBJECT CREATION WITHOUT PASSING ANY PARAMETERS POSSIBLE

    var name = "Anonymous";
    var age = 1;
    constructor(name : String , age : Int) : this(){
        this.name = name;
        this.age = age;
    }

    fun displayName(){ println("Name = $name") }
    fun displayAge(){ println("Age $age") }
}

fun main(){
    val pc = PrimaryConstructor("Abhishek" , 18)
    pc.displayName()
    pc.displayAge()

    val sc = SecondaryConstructor("Aditya" , 22) // default value of school is used
    sc.displayName()
    sc.displayAge()
    sc.displaySchool()

    val spc = SkipPrimaryConstructor()
    spc.displayName()
    spc.displayAge()
}