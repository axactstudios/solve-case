package com.example.jiitsolutions

data class FileName(var fname:String)
object fileList{
    fun getRandomString(length: Int) : String {
        val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
    val Files= listOf<FileName>(
        FileName(getRandomString(10)),
        FileName("Tute 2"),
        FileName(getRandomString(10)),
        FileName(getRandomString(10)),
        FileName(getRandomString(10)),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3"),
        FileName("Tute 1"),
        FileName("Tute 2"),
        FileName("Tute 3")
        )

}