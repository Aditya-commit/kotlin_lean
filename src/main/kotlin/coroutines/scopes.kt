package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext


/*

COROUTINESCOPE TELLS WHERE THE COUROUTINE LIVES
------------------------------------------------

NOW HERE USING coroutineScope IF WE CANCEL THE PARENT COROUTINESCOPE THEN ITS CHILDREN COROUTINE ARE ALSO CANCELLED INSTEAD OF RUNNING THEM INDEPENDENTLY WITHOUT ANY CONTROL , ALSO HAPPENS WITH supervisorScope. THIS IS CALLED STRUCTURED CONCURRENCY

 */
suspend fun loadDashboard() = coroutineScope {
    launch {
//        SOME SUSPEND FUNCTION
    }
    launch {
//        SOME SUSPEND FUNCTION
    }
}







/*

coroutineScope versus supervisorScope
-------------------------------------

With coroutineScope, a child failure generally cancels the scope and its other children.
With supervisorScope, a child can fail without automatically cancelling its siblings. You still need to handle the failed child's exception appropriately.

*/


suspend fun loadMetaData(){
//    DO SOME NETWORK I/O
}

suspend fun loadMainContent(){
//    DO SOME NETWORK I/O
}

suspend fun loadScreen() = supervisorScope {

    launch {
        try{
            loadMetaData()
        }
        catch (e: Exception){
//            HANDLE THE ERROR
        }
    }

    launch{
        loadMetaData()
    }

//    NOW HERE FAILURE OF loadMetaData() WILL NOT CAUSE FAILURE OF ITS SIBBLING BECAUSE WE ARE USING supervisorScope

}
























// WORKING EXAMPLE

suspend fun passFun(){
    delay(2000L)
    print("Pass fun finshed")
}

suspend fun failFun(){
    delay(4000L)
    throw Exception("Internal Server Error")
}

suspend fun thirdFunc(){
    delay(5000L)
    println("Finished third func")
}

suspend fun main() = supervisorScope {

    val passJob = launch { passFun() }
    val failJob  = launch { failFun() }
    val thirdJob = launch { thirdFunc() }

    passJob.join()
    failJob.join()
    thirdJob.join()

    println()
    println("Code finished")
}

/*
    WHEN USING coroutineScope THE ENTIRE COROUTINE SCOPE AND ALL ITS CHILDREN COROUTINE CRASHES AFTER 4 SECONDS
    WHEN USING supervisorScope ONLY THE failJob FUNCTION FAILS AND REST OF THE CODE CONTINUES TO WORK

 */