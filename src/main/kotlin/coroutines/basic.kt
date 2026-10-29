package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

//fun main() = runBlocking<Unit> {
////    runBlocking CREATES A COUROUTINE SCOPE THAT IS NEEDS FOR THE JOBS TO RUN , AND IT ALSO HOLD THE PARENT COUROUTINE UNTIL THE CHILD COUROUTINES ARE COMPLETED (IT USED THE CURRENT THREAD IN THIS CASE THE MAIN THREAD)
//
////    HERE IT WILL PUT ALL THE THREE JOBS IN AN EVENT LOOP , IN A SINGLE THREAD
////    TOTAL TIME FOR ALL JOBS TO FINISH = 4 SECONDS (NEGLECTING THE SCHEDULE TIME)
//
//    val cakeJob = launch {
//        delay(1000L)
//        println("Cake is prepared!")
//    }
//
//    val IcecreamJob = launch {
//        delay(4000L)
//        println("Icecream is prepared!")
//    }
//
//    val pastaJob = launch {
//        delay(3000L)
//        println("Paasta is prepared!")
//    }
//
//    println("------ Code started ---------")
//    cakeJob.join()
//    IcecreamJob.join()
//    pastaJob.join()
//    println("-------- Code finished ---------")
//}

// _______________________________________________________________________________________________________________________________________________________________________

// SAME CODE WITH SUSPEND FUNCTIONALITY


// SUSPEND GIVES PERMISSION TO COMPILER THAT IT CAN PERFORM OTHER TASKS WHILE I WILL DO SOME BLOCKING OPERATION (NOTE : IT DOES NOT OERDERS THE COMPILER TO WORK OTHER TASK WHILE IT IS BEING MAKING NETWORK REQUEST OR DOING FILE I/O)
// TO ACTUALLY MAKE THAT SUSPEND FUNCTION RUN AT BACKGROUND OR BEHAVE AS ASYNC , WE HAVE TO USE COUROUTINES LAUNCHER LIKE (ASYNC , LAUNCH)

suspend fun cakeJob(){
    delay(1000L)
    println("Cake is prepared!")
}

suspend fun icecreamJob(){
    delay(4000L)
    println("Ice Cream is prepared!")
}

suspend fun paastaJob(){
    delay(3000L)
    println("Paasta is prepared!")
}

fun main() = runBlocking<Unit> {

//    USING LAUNCH

//    val cake = launch { cakeJob() }
//    val icecream = launch { icecreamJob() }
//    val paasta = launch { paastaJob() }
//
//    cake.join()
//    icecream.join()
//    paasta.join()




//    USING ASYNC (IT IS USED WHEN OUR SUSPEND FUNCTION HAS TO RETURN SOMETHING)

    val cake = async { cakeJob() }
    val icecream = async { icecreamJob() }
    val paasta = async { paastaJob() }

    cake.await()
    icecream.await()
    paasta.await()


    println("Order delievered");
}


// NOTE : ALL THESE ARE USING SINGLE THREAD , WE FEEL LIKE THEY ARE RUNNING IN PARALLEL BECUASE CONTROL GOES TO OTHER FUNCTION INSTEAD OF WAITING FOR ONE SUSPEND FUNCTION TO FINISH