@file:Suppress("unused")

package azadev.kotlin.css.dimens

import azadev.kotlin.css.cssDecimalFormat


class LinearDimension(
		var value: Float,
		var units: LinearUnits
) {
	override fun toString(): String {
		val str = cssDecimalFormat.format(value)!!
		return if (str == "0") str else "$str$units"
	}


	companion object
	{
		fun from(value: Any): LinearDimension {
			return when (value) {
				is Number -> value.px
				is String -> fromString(value)
				is LinearDimension -> value
				else -> throw IllegalArgumentException("Cannot create LinearDimension from ${value::class.simpleName}")
			}
		}

		fun fromString(s: String): LinearDimension {
			if (s.endsWith('%'))
				return LinearDimension(s.dropLast(1).toFloat(), LinearUnits.PERCENT)

			val units = when {
				s.endsWith("px")    -> LinearUnits.PX
				s.endsWith("em")    -> LinearUnits.EM
				s.endsWith("ex")    -> LinearUnits.EX

				s.endsWith("in")    -> LinearUnits.INCH
				s.endsWith("cm")    -> LinearUnits.CM
				s.endsWith("mm")    -> LinearUnits.MM
				s.endsWith("pt")    -> LinearUnits.PT
				s.endsWith("pc")    -> LinearUnits.PC

				else -> null
			}

			if (units != null)
				return LinearDimension(s.dropLast(2).toFloat(), units)

			return LinearDimension(s.toFloat(), LinearUnits.PX)
		}
	}
}
