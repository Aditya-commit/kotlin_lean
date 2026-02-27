fun main(){

    val userInputs = mutableListOf<Int>();
    var sum = 0;

    var i = 1;
    while(i <= 5){
        print("Enter number #${i} - ")
        val number = readln()
        println()

        try{
            val numberAsInteger = number.toInt();
            userInputs.add(numberAsInteger);
            i += 1
        }
        catch(e: NumberFormatException){
            println("Dude , please enter only numbers")
            continue;
        }
    }

    for(i in userInputs){
        sum += i;
    }

    println("The sum of all the entered numbers ${userInputs.toString()} = ${sum}")
}