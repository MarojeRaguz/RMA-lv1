import kotlin.random.Random
class Die {
    var side: Int =0
    var isLocked: Boolean = false

    fun roll(){
        val maxValue = 6
        val minValue = 1
        this.side = Random(System.nanoTime()).nextInt(minValue, maxValue +1)
    }
}