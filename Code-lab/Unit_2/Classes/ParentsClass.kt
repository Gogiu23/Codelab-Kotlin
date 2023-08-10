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
