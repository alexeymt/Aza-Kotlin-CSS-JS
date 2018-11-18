package azadev.kotlin.css.dimens


enum class LinearUnits(
		val value: String
) {
	// Relative units
	PX("px"),
	EM("em"),
	REM("rem"),
	PERCENT("%"),
	EX("ex"), // The height of 'x' char

	// Absolute units
	INCH("in"), // 2.54 cm
	CM("cm"),
	MM("mm"),
	PT("pt"),   // 1/72 in
	PC("pc");   // 12 pt;


	override fun toString() = value
}
