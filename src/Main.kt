import java.util.*
import kotlin.collections.ArrayList

val userList = ArrayList<DataUser>()
var userLogged: DataUser? = null

fun main(){
    printMainMenu()
}

fun printHeader(){
    println("===============")
    println("PROGRAM SUIT")
    println("===============")
}

fun printMainMenu(){

    var pil: String
    do {
        printHeader()
        println("1. Register")
        println("2. Login")
        print("Masukkan Pilihan Anda [1/2]: ")
        pil = readLine()!!

        if(pil.isContainsLetter()){
            println("Inputan tidak sesuai")
        }else{
            when(pil.toInt()){
                1 -> {
                    val dataUser = printRegis()
                    userList.add(dataUser)
                    printHeader()
                    printMainMenu()
                }
                2 ->{
                    printLogin()
                }
                else -> println("Inputan tidak sesuai")
            }
        }
    }while(pil.isContainsLetter() || pil.toInt()>2)




}

fun String.isContainsLetter() = all { it.isLetter() }

fun printRegis():DataUser{
    var username: String
    var password:String
    do {
        printHeader()
        println("Register")
        print("Input Username: ")
        username = readLine()!!
        print("Input Password: ")
        password = readLine()!!
    }while (username.length<4 || password.length<4)


    return DataUser(username.lowercase(), password)
}

fun printLogin(){
    var username: String
    var password:String
    var isLogin = false
    do {
        printHeader()
        println("Login")
        print("Input Username: ")
        username = readLine()!!
        print("Input Password: ")
        password = readLine()!!

        userList.forEach {
            if (it.username == username && it.password == password){
                isLogin = true
                userLogged = it
            }
        }
        if (!isLogin){
            println("Gagal login, periksa username/password anda")
        }else{
            println("Berhasil Login")
            printSuitGame()
        }

    }while (!isLogin)
}

fun printSuitGame() {
    printHeader()
    println("Welcome! Logged as: ${userLogged?.username}")
    val cpuInput = Random().nextInt(1,4)
    var pil: String
    do {
        printHeader()
        println("Welcome! Logged as: ${userLogged?.username}")
        println("Available moves")
        println("1. Gunting")
        println("2. Batu")
        println("3. Kertas")
        print("Masukkan Pilihan Anda [1-3]: ")
        pil = readLine()!!

        if(pil.isContainsLetter()){
            println("Inputan tidak sesuai")
        }else if (pil.toInt()>3){
            println("Inputan tidak sesuai")
        }else{
            val suitRule = SuitRule(pil.toInt(),cpuInput)
            println("${userLogged?.username} Input: ${suitRule.userInputString()}")
            println("Cpu Input: ${suitRule.cpuInputString()}")
            println("\n\nResult: ${userLogged?.username} ${suitRule.doSuit()}")
        }

    }while(pil.isContainsLetter() || pil.toInt()>3)

}

