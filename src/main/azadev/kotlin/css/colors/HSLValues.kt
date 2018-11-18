package azadev.kotlin.css.colors


class HSLValues(
		var hue: Float,
		var saturation: Float,
		var lightness: Float
) {
	fun setLightnessSafe(l: Float): HSLValues {
		lightness = minOf(1f, maxOf(0f, l))
		return this
	}

	fun setSaturationSafe(l: Float): HSLValues {
		saturation = minOf(1f, maxOf(0f, l))
		return this
	}
}
