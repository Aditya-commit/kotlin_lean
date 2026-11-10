package api

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val client = HttpClient(engineFactory = Android) {
    expectSuccess = true // THROWS ERROR ON NON 2XX STATUS CODE ( DO NOT USE THIS - MY SUGGESTION )
    followRedirects =
        true // By default, the Ktor client redirects to URLs provided in the Location header. If required, you can disable redirections.
    install(HttpRequestRetry) {
        maxRetries = 2 // FOR ALL FAILED REQUESTS
        retryOnServerErrors(maxRetries = 5) // WHEN RECEIVING 500 STATUS CODE
        exponentialDelay(
            base = 2.0, // DELAY MULTIPLIER
            baseDelayMs = 1000, // INITIAL DELAY
            maxDelayMs = 5000, // STOP MULTIPLYING THE DELAY WITH base AFTER REACHING TO maxDelayMs
            2000 // prevents "THUNDERING PROBLEM" by (base + random(1..2000)) SO THAT ALL THE DEVICES DO NOT SEND THE RETRY REQUEST AT THE SAME EXACT SAME TIME TO SERVER THAT JUST CAME ONLINE FROM CRASH OR UPDATE
        )

    } // Should be installed before HttpTimeout
    install(HttpTimeout) {
        requestTimeoutMillis = 3000
        connectTimeoutMillis = 1000
        socketTimeoutMillis = 1000
    }
    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens("abc123", "xyz111")
            }
            sendWithoutRequest { request ->
                request.url.host === "localhost:8000"
            }
        }
    }
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
        acceptHeaderMergeStrategy =
            ContentTypeMergeStrategy.SkipIfPresent // Ktor’s default strategy does not replace the header; it merges them together. The outgoing HTTP request will actually look like Accept: <DEFAULT>, <OUR OWN ADDED ONE>. IF WE DO NOT WANT THIS THEN USE THIS CONFIGURATION
    }
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "jsonplaceholder.typicode.com"
            path("/")
        }
    }
}

/*
                INTERCEPTOR

client.plugin(HTTPSend).intercept { request ->
    val originalCall = execute(request)
    if (originalCall.response.status.value !in 100..399) {
//        DO SOMETHING / CALL ANY OTHER REQUEST
        originalCall() // RE RUN THE ORIGINAL REQUEST
    } else {
        originalCall // ON SUCCESS PASS THE RESULT OF ORIGINAL REQUEST
    }
}

*/

fun apiClient(): HttpClient {
    return client
}