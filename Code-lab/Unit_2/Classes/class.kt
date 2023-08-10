open class SmartDevice(val name:String, val category: String) {

	val deviceStatus = "online"

		fun turnOn() {
			println("light is on")
		}
	fun turnOff() {
		println("light is off")
	}
}	

fun main() {
	val smartTvDevice = SmartDevice()
		println("Device name is: ${smartTvDevice.name}")
		smartTvDevice.turnOn()
		smartTvDevice.turnOff()
}
