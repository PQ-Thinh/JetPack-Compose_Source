package com.example.ggsouresjetpack.Decorator

fun main(){
     val mau =  Context()
    val c1 = Cong()
    mau.setTinhToan(c1)
    println(mau.tinh(8f,9f))
}