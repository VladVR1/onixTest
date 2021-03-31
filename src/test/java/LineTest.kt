import org.junit.Test

class LineTest {

    @Test
    fun trim() {
        val line = Line(" trim ")
        assert(line.trim() == Line("trim"))
    }

    @Test
    fun plus() {
        val hello = Line("Hello")
        val space = Line(" ")
        val world = Line("World")
        assert(hello + space + world == Line("Hello World"))
    }

    @Test
    fun find() {
       val word =  Line("Hello World")
        assert(word.find(Line("Hello")))
    }

    @Test
    fun toFloat() {
        val word =  Line("1.5")
        assert(word.toFloat() == 1.5f)
    }
    @Test
    fun toLine() {
        val int =  12
        assert(int.toLine() == Line("12"))
    }

}
