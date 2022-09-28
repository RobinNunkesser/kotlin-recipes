const val Ist = "Erstmal gut,"
const val gut = " aber durchaus "
const val schlecht = "gefährlich!"

infix fun String.oder(s: String)  {
    println(this + s)
}

infix fun String.das(s: String) : String {
    return this + s
}
