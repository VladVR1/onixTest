class Line : CharSequence {
    override val length: Int
    private var array: CharArray

    constructor(charArray: CharArray) {
        length = charArray.size
        array = charArray
    }

    constructor(charSequence: CharSequence = "") {
        length = charSequence.length
        array = CharArray(length)
        for (i in 0 until length) {
            array[i] = charSequence[i]
        }
    }

    override fun get(index: Int): Char {
        return array[index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): Line {
        if ((startIndex == -1 || startIndex == 0) && (endIndex == -1 || endIndex == length - 1)) {
            return this
        }
        var stIn = 0
        var edIn = length - 1
        if (startIndex > 0) {
            stIn = startIndex
        }
        if (endIndex > 0) {
            edIn = endIndex
        }

        var count = 0
        for (i in stIn..edIn) {
            count = i
        }

        val charArray = CharArray(count)
        for ((index, i) in (stIn..edIn).withIndex()) {
            charArray[index] = array[i]
        }
        return Line(charArray)
    }

    fun trim(): Line {
        var startIndex = 0
        var endIndex = 0
        for (i in 0 until length) {
            if (array[i] == ' ') {
                startIndex = i
            } else {
                break
            }
        }
        for (i in (length - 1) downTo 0) {
            if (array[i] == ' ') {
                endIndex = i
            } else {
                break
            }
        }
        return subSequence(startIndex + 1, endIndex - 1)
    }

    operator fun plus(line: Line): Line {
        return Line(array + line.array)
    }

    fun find(line: Line): Boolean {

        try {
            val parentSize: Int = array.size
            val whatSize: Int = line.length
            if (whatSize > parentSize) {
                return false
            }
            var founded = 0
            for (i in 0 until parentSize) {
                if (array[i] == line[founded]) {
                    founded++
                } else {
                    founded = 0
                }
                if (founded == whatSize) {
                    return true
                }
            }
        } catch (e: Exception) {
        }
        return false
    }


    fun toFloat(): Float {
        return toString().toFloat()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Line

        if (length != other.length) return false
        if (!array.contentEquals(other.array)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length
        result = 31 * result + array.contentHashCode()
        return result
    }

    override fun toString(): String {
        return String(array)
    }


}

fun Int.toLine(): Line {
    return Line(toString())
}