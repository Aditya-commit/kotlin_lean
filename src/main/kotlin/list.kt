fun main(){
//    LIST ARE MUTABLE AS WELL AS IMMUTABLE (READ ONLY) WE CAN ADD OR REMOVE

//    listOf() - READ ONLY (IMMUTABLE)
//    mutableListOf<Type>() -> MUTABLE

    val names = mutableListOf<String>("Jack", "John", "Peter", "Jane")

    println(names.toString())

    names.add("Ishu")

    println(names.toString())
}