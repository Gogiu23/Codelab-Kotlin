import kotlin.properties.ReadWriteProperty 
import kotlin.reflect.KProperty


open class SmartDevice(val name: String, val category: String) {

	open fun printDeviceInfo() {}

	open fun decreaseVolume() {}

	open fun previousChannel() {}

	open fun decreaseBrightness() {}

	var deviceStatus = "online"
	protected set(value){
		field = value
	}

	open val deviceType = "unknown"
	constructor(name: String, category: String, statusCode: Int) : this(name, category) {
		deviceStatus = when (statusCode) {
			0 -> "offline"
			1 -> "online"
			else -> "uknown"
		}
	}
	open fun turnOn() {
		deviceStatus = "on"
	}
	open fun turnOff() {
		deviceStatus = "off"
	}

}

class SmartTvDevice(deviceName: String, deviceCategory: String) : 
SmartDevice(name = deviceName, category = deviceCategory) {

	private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
	private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

	override val deviceType = "Smart TV"

	override fun turnOn() {
		super.turnOn()
		println(
			"$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
			"set to $channelNumber."
		)
	}

	override fun decreaseVolume() {
		speakerVolume--
		println("Speaker volume decreased to $speakerVolume.")
	}

	override fun previousChannel() {
		channelNumber--
		println("Channel number decreased to $channelNumber.")
	}

	override fun printDeviceInfo() {
		super.printDeviceInfo()
		println("Device Name: ${name}")
		println("Category: ${category}")
		println("type: ${deviceType}")
	}

	override fun turnOff() {
		super.turnOff()
		println("$name turned off")
	}
	fun increaseSpeakerVolume() {
		speakerVolume++
		println("Speaker volume increased to $speakerVolume.")
	}

	fun nextChannel() {
		channelNumber++
		println("Channel number increased to $channelNumber.")
	}
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : 
SmartDevice(name = deviceName, category = deviceCategory){

	// private var brightnessLevel = 0
	private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

	override val deviceType = "Smart light"

	override fun decreaseBrightness() {
		brightnessLevel--
		println("Brightness level decreased to $brightnessLevel.")
	}

	override fun printDeviceInfo() {
		super.printDeviceInfo()
		println("Device Name: ${name}")
		println("Category: ${category}")
		println("type: ${deviceType}")
	}

	override fun turnOn() {
		super.turnOn()
		brightnessLevel = 2
		println("$name turned on. The brightness level is $brightnessLevel.")
	}

	override fun turnOff() {
		super.turnOff()
		brightnessLevel = 0
		println("Smart Light turned off")
	}

	fun increaseBrightness() {
		brightnessLevel++
		println("Brightness increased to $brightnessLevel.")
	}
}

class SmartHome(
	val smartTvDevice: SmartTvDevice,
	val smartLightDevice: SmartLightDevice
) {
	var deviceTurnOnCount = 0
	private set

	fun decreaseVolume() {
		smartTvDevice.decreaseVolume()
	}
	
	fun decreaseBrightness() {
		smartLightDevice.decreaseBrightness()
	}

	fun previousChannel() {
		smartTvDevice.previousChannel()
	}

	fun printDeviceInfo() {
		smartTvDevice.printDeviceInfo()
		smartLightDevice.printDeviceInfo()
	}

	fun turnOnTv() {
		deviceTurnOnCount++
		smartTvDevice.turnOn()
	}

	fun turnOffTv() {
		deviceTurnOnCount--
		smartTvDevice.turnOff()
	}
	fun increaseTvVolume() {
		smartTvDevice.increaseSpeakerVolume()
	}

	fun changeTvChannelToNext() {
		smartTvDevice.nextChannel()
	}
	fun turnOnLight() {
		deviceTurnOnCount++
		smartLightDevice.turnOn()
	}

	fun turnOffLight() {
		deviceTurnOnCount--
		smartLightDevice.turnOff()
	}
	fun increaseLightBrightness() {
		smartLightDevice.increaseBrightness()
	}
	fun turnOffAllDevices() {
		turnOffTv()
		turnOffLight()
	}
}

class RangeRegulator(
	initialValue: Int,
	private val minValue: Int,
	private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

	var fieldData = initialValue

	//Note: The KProperty is an interface that represents a declared property and lets you access the
	//metadata on a delegated property.
	//It's good to have high-level information about what the KProperty is.

	override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
		return fieldData;
	}
	override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
		if (value in minValue..maxValue) {
			fieldData = value
		}
	}

}

fun main() {
	val smartHome = SmartHome(
		SmartTvDevice("AndroidTV", "Entertainment"), 
		SmartLightDevice("Google Light", "Utility")
	)

	smartHome.printDeviceInfo()
	smartHome.turnOnTv()
	smartHome.turnOnLight()
	println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
	println()

	smartHome.increaseTvVolume()
	smartHome.changeTvChannelToNext()
	smartHome.increaseLightBrightness()
	println()

	smartHome.decreaseVolume()
	smartHome.previousChannel()
	smartHome.decreaseBrightness()
	println()


	smartHome.turnOffAllDevices()
	println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
}
