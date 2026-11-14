// Sealed classes and sealed interfaces are used when you want to define a restricted set of possible types.

// They are particularly useful when you want to model states, events, results, or business scenarios where the possibilities are known in advance.

// A sealed class is an abstract class whose direct subclasses are restricted to a known set.

sealed class Result {
//    WE ARE USING DATA CLASS BECAUSE THE ACTUAL BUSINESS LOGIC WE WILL BE WRITING IN OTHER FUNCTION
    data class Success(val data : String) : Result()
    data class Error(val exception : String) : Result()
    data object Loading : Result()
}

fun handleResult(result : Result){
    when(result){
        is Result.Success -> {
            // PERFORM BUSINESS LOGIC HERE
            println(result.data)
        }
        is Result.Error -> println(result.exception)
        Result.Loading -> println("LOADING Data Please wait ...")
    }
}

fun main(){

    val apiLoading = Result.Loading // SINCE ITS DATA OBJECT WE CAN OMIT ()
    handleResult(apiLoading)

    val apiResult = Result.Success("Your name is Aditya")
    handleResult(apiResult)

    println(apiLoading == apiResult) // IT COMPARES PLAIN DATA INSTEAD OF THE OBJECT REFERENCES
}

// HERE WE COULD NOT HAVE USED ENUMS ALTHOUGH THEY ALSO PERFORM IDENTICAL BECAUSE ENUMS WORK WITH STATIC CONTENT THAT WE KNOW BEFOREHAND WHERE AS SEALED CLASS + DATA CLASS IS USED WHEN THE DATA IS DYNAMIC LIKE IN API RESPONSE
