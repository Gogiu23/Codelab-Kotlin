class SmartTvDevice(deviceName: String, deviceCategory: String) : (SmartDevice(name = deviceName, category = deviceCategory) {
	class SmartLightDevice(deviceName: String, deviceCategory: String) : (SmartDevice(name = deviceName, category = deviceCategory) {
		var brightnessLevel = 0
		set(value) {
			if (value in 0..100) {
				field = value
			}
		}
		fun increaseBrightness() {
			brightnessLevel++
			println("Brightness increased to $brightnessLevel")
		}
	}

	class SmartHome(
		val smartTvDevice: SmartTvDevice,
		val SmartLightDevice: SmartLightDevice
	) {
		fun turnOnTv() {
			smartTvDevice.turnOn()
		}
		fun	tunrOffTv() {
			smartTvDevice.tunrOffTv()
		}
		fun increaseTvVolume() {
			smartTvDevice.increaseSpeakerVolume()
		}
		fun changeTvChannelToNext() {
			smartTvDevice.nextChannel()
		}
		fun turnOnLight() {
			SmartLightDevice.turnOn()
		}
		fun turnOffLight() {
			SmartLightDevice.turnOff()
		}
		fun increaseLightBrightness() {
			SmartLightDevice.increaseBrightness()
		}
		fun turnOffAllDevices() {
			turnOffTv()
			turnOffLight()
		}
	}
	var speakerVolume = 2
	set(value) {
		if (value in 0..100) {
			field = value
		}
	}
	var channelNumber = 1
	set(value) {
		if (value in 0..200) {
			field = value
		}
	}
	fun increaseSpeakerVolume() {
		speakerVolume++
		println("Speaker volume increased to $speakerVolume. ")
	}
	fun nextChannel() {
		channelNumber++
		println("Channel number increased to $channelNumber")
	}
}

open class SmartDevice(val name:String, val category: String) {

	val deviceStatus = "online"

	constructor(name: String, category: String, statusCode: Int) : this(name, category) {
		deviceStatus = when (statusCode) {
			0 -> "offline"
			1 -> "online"
			else -> "uknown"
		}
	}

	open fun turnOn() {
		println("light is on")
	}
	open fun turnOff() {
		println("light is off")
	}
}	

fun main() {
	val smartTvDevice = SmartDevice()
	println("Device name is: ${smartTvDevice.name}")
	smartTvDevice.turnOn()
	smartTvDevice.turnOff()
}



