package api

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class PostBody(val title: String, val userId: Int)

suspend fun sendPost(postBody: PostBody) {
    val client = apiClient()

    val response : io.ktor.client.statement.HttpResponse = client.post("https://dummyjson.com/posts/add"){
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
        setBody(postBody)
    }

    val body : String = response.body()

    println(response.status.value)
    println(response.headers["Content-Type"])
    println(body)
}

fun main() = runBlocking {
    val job = launch { sendPost(PostBody("Testing kotlin post request method" , userId = 34)) }
    job.join()
}