enum class DIRECTIONS {
    NORTH , SOUTH , EAST , WEST
}

enum class TRAFFIC_LIGHT(val action : String){
    RED("STOP"),
    YELLOW("READY"),
    GREEN("START")
}

fun main(){
    val directions = DIRECTIONS.NORTH // IN REAL APPLICATION THIS VALUE WILL COME FROM THE SERVER

    when(directions){
        DIRECTIONS.NORTH -> println("North")
        DIRECTIONS.SOUTH -> println("South")
        DIRECTIONS.EAST -> println("East")
        DIRECTIONS.WEST -> println("West")
    }

    val light = TRAFFIC_LIGHT.RED

    println(light.action)
    println(light)

    println(TRAFFIC_LIGHT.YELLOW)
    println(TRAFFIC_LIGHT.YELLOW.action)
}