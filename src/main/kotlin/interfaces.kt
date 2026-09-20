interface Features {
    val brand : String
    val type : String
        get() = "Electronics" // type will return the Electronics as default value

    fun powerOn() // ABSTRACT METHOD (THEY ARE MUST TO BE OVERRIDEN BY THE CLASS THAT INHERIT THIS INTERFACE)
    fun powerOff() // ABSTRACT METHOD (THEY ARE MUST TO BE OVERRIDEN BY THE CLASS THAT INHERIT THIS INTERFACE)
    fun sleep() // ABSTRACT METHOD (THEY ARE MUST TO BE OVERRIDEN BY THE CLASS THAT INHERIT THIS INTERFACE)
    fun update(){
//        DEFAULT FUNCTION BODY (NOT REQUIRED TO OVERRIDE)
        println("No updates yet")
    }
}

interface HardWare {
    fun connectSpeaker()
    fun disconnectSpeaker()
}

class AcRemote : Features {
    override val brand: String = "LG"
    override fun powerOn()= println("Ac On")
    override fun powerOff()= println("Ac Off")
    override fun sleep()= println("Ac put to sleep")
}

class TvRemote : Features , HardWare {
    override val brand: String = "Samsung"
    override fun powerOn(){ println("Tv On") }
    override fun powerOff()= println("Tv Off")
    override fun sleep()= println("Tv put to sleep")
    override fun update(){println("Your tv remote has been updated successfully") }

    override fun connectSpeaker() = println("Speaker connected successfully")
    override fun disconnectSpeaker() = println("Speaker disconnected successfully")

    fun displayBrand(){println("The TV brand is $brand")}
}

fun main(){
    val ac = AcRemote()
    println("The Ac brand is ${ac.brand}")
    ac.powerOn()
    ac.powerOff()
    ac.sleep()
    ac.update()

    println("")

    val tv = TvRemote() // THIS WILL CONTAIN BOTH THE INTERFACE METHODS (FEATURES , HARDWARE)
    tv.powerOn()
    tv.connectSpeaker()
    tv.disconnectSpeaker()
    tv.powerOff()
    tv.sleep()
    tv.update()
    tv.displayBrand()

    val tvSpeaker : HardWare = TvRemote() // THIS ONLY CONTAINS THE ABSTRACT METHODS OF INTEFACE HARDWARE BECUASE WE HAVE DEFINED THE INTERFACE TYPE WHILE OBJECT CREATION OF THE CLASS
    tvSpeaker.connectSpeaker()
    tvSpeaker.disconnectSpeaker()
}