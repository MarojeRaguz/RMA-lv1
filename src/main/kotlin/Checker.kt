import java.util.*

class Checker {
    private fun isYamb(dice: List<Die>):Boolean{
        return dice.groupingBy { it.side }.eachCount().filter { it.value>=5 }.isNotEmpty()
    }
    private fun isPoker(dice: List<Die>):Boolean{
        return dice.groupingBy { it.side }.eachCount().filter { it.value==4 }.isNotEmpty()
    }

    private fun isScale(dice: List<Die>):Boolean{
        val diceValues = mutableListOf<Int>()
        for(die in dice){
            diceValues.add(die.side)
        }
        val smallScale= listOf(1,2,3,4,5)
        val bigScale = listOf(2,3,4,5,6)
        return diceValues.containsAll(smallScale) || diceValues.containsAll(bigScale)
    }
    private fun isFullHouse(dice: List<Die>):Boolean{
        var nOfRepetitions = mutableListOf<Int>()
        for (i in 1..6) {
            var counter=0
            for (die in dice){
                if (die.side==i){
                    counter++
                }
            }
            nOfRepetitions.add(i-1,counter)
        }
        return nOfRepetitions.count { it > 2 } >=2 || (nOfRepetitions.count { it > 2 } ==1 && nOfRepetitions.contains(2))
    }

    fun check(dice: List<Die>):String{
        return "yamb: ${isYamb(dice)}\t poker: ${isPoker(dice)}\tscale: ${isScale(dice)}\tfullHouse: ${isFullHouse(dice)}"
    }
}