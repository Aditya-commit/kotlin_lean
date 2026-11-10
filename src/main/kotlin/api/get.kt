package api

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data class Album(val userId: Int, val id: Int, val title: String)

suspend fun getSinglePost(){
    println("Getting Post")
    println()

    val response : HttpResponse = apiClient().get("posts/1")
    println(response.status.value)
    println(response.headers["Content-Type"])
    val body : String = response.body()
    println(body)

}

// ANOTHER METHOD USING 'use'
suspend fun getAlbum(){
    println("Getting Album")
    println()

//    HERE use WILL AUTOMATICALLY CLOSE THE CLIENT
    val response : HttpResponse = apiClient().use { client ->  client.get("albums/2") }
    println(response.status)
    val body : Album = response.body()
    println(body.userId)
}

suspend fun main() = coroutineScope {
    val postJob = launch { getSinglePost() }
    val albumJob = launch { getAlbum() }

    postJob.join()
    albumJob.join()

//    WE ARE USING ASYNC TECHNIQUES TO RUN TWO REQUEST CONCURRENTLY 😁
}