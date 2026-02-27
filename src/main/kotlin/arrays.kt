fun main(){
//    ARRAYS ARE IMMUTABLE (ONCE THEY ARE CREATED THEY CANNOT BE CHANGED THAT'S WHY ADDING NEW ELEMENTS IT WAS CREATING A NEW ARRAY WHICH WE HAVE TO STORE IN A VARIABLE
    val names = arrayOf("Jack", "John", "Peter", "Jane") // USE THIS WHEN ARRAY SIZE IF FIXED [ TIME COMPLEXITY O(1)] BEST FOR PERFORMANCE
    val ages = arrayOf(23 , 44 , 53 , 23)
    val optimizedAges = intArrayOf(23 , 44 , 53  , 23) // THIS IS MUCH FASTER THAN arrayOf<Int>();

    println(names.count())
    val new_names = names + "Ishu" // + always returns a new array
    println(new_names.count())

    println(ages.count())
    ages + 20
    println(ages.count())
    print(names[0])
    println(" ${ages[0]}")
}