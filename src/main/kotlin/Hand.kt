class Hand(
) {
    var dice= mutableListOf<Die>()
    init {
        for (i in 1..6){
            dice.add(Die())
        }
    }
    fun roll(){
        for(die in dice){
            if (!die.isLocked){
                die.roll()
            }
        }
    }

    fun lockDice(diceToLock: Array<Int>){
        for(i in 1..6){
            dice[i-1].isLocked=diceToLock.contains(i)
        }

    }

    fun printDice(){
        for(die in dice){
            print("die ${dice.indexOf(die)+1}: ${die.side}\t")
        }
        println()
    }

}

