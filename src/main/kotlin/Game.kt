import java.util.*

class Game (
    var hand:Hand=Hand(),
    private var checker:Checker =Checker()
){
    fun startGame(){
        println("game is strarting...")
        for (i in 1..13){
            println("turn number $i")
            takeTurn()
            println("turn number $i is over\n\n")
            println("type exit if you want to stop playing or press enter to continue playing")
            val entered= readLine()
            if(entered?.lowercase()=="exit"){
                break;
            }

        }
        println("thank you for playing")
    }

    private fun takeTurn(){
        for (i in 1..3){
            println("throw number $i")
            hand.roll()
            hand.printDice()
            println(checker.check(hand.dice))
            if(i<3){
                println("enter number of dice to lock separated by ',' and press enter")
                var entered = readLine()!!
                if(entered!=""){
                    var diceToLock= entered.split(',').map{it.toInt()}.toTypedArray()
                    hand.lockDice(diceToLock)
                }

            }
        }
    }
}