fun main() {
	// val cupcake: (Int) -> String = {
		//     "Have a cupcake"
		// }

		val treatFunction = trickOrTreat(false) { "$it quarters" }
		val trickFunction = trickOrTreat(true, null)
		// treatFunction()
		repeat(4) { 
			treatFunction()
		}
		trickFunction()
	}

	fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
		if (isTrick) {
			return trick
		} else {
			if (extraTreat != null) {
				println(extraTreat(5))
			}
			return treat
		}
	}

	val trick = {
		println("No treats") // lambda expression
	}

	val treat: () -> Unit = {
		println("Have a treat!")
	}
