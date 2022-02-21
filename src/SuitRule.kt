
class SuitRule(userInput: Int, cpuInput: Int) {

    private lateinit var userInputSuitItem: SuitItem
    private lateinit var cpuInputSuitItem: SuitItem

    init {
        when(userInput){
            1 -> userInputSuitItem = SuitItem.GUNTING
            2 -> userInputSuitItem = SuitItem.BATU
            3 -> userInputSuitItem = SuitItem.KERTAS
        }

        when(cpuInput){
            1 -> cpuInputSuitItem = SuitItem.GUNTING
            2 -> cpuInputSuitItem = SuitItem.BATU
            3 -> cpuInputSuitItem = SuitItem.KERTAS
        }
    }

    fun doSuit(): String{
        return if ((userInputSuitItem==SuitItem.GUNTING && cpuInputSuitItem==SuitItem.GUNTING)||(userInputSuitItem==SuitItem.BATU && cpuInputSuitItem==SuitItem.BATU)||
            (userInputSuitItem==SuitItem.KERTAS && cpuInputSuitItem==SuitItem.KERTAS)){
            "DRAW"
        }else if((userInputSuitItem==SuitItem.GUNTING && cpuInputSuitItem==SuitItem.BATU)||(userInputSuitItem==SuitItem.KERTAS && cpuInputSuitItem==SuitItem.GUNTING)||
            (userInputSuitItem==SuitItem.BATU && cpuInputSuitItem==SuitItem.KERTAS)){
            "LOSE"
        }else{
            "WIN"
        }
    }

    fun userInputString():String{
        return userInputSuitItem.toString()
    }

    fun cpuInputString():String{
        return cpuInputSuitItem.toString()
    }

}