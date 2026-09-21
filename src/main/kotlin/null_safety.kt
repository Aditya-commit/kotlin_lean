fun main(){
    var name : String? = "Hi"

    println(name!!.length) // IT TELLS THE COMPILER THAT THE VARIABLE THAT CAN BE NULL IS NOT NULL
    name = null

    println(name)
    println(name?.length)

    if(name === null){
        println("It is null")
    }
    else{
        println("It is not null")
    }

    println(name.toString())

    name?.let { println("Hi my name is $it")} // THIS WILL ONLY RUN IF NAME IS NOT NULL
    name.let { println("Hi my name is $it")} // THIS WILL RUN EVERY TIME
}