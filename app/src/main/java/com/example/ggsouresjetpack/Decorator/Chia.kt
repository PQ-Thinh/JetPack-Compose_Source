package com.example.ggsouresjetpack.Decorator

class Chia: Tinh {
    override fun tinh(a: Float, b: Float): Float {
        if (b==0f){
            println("eo chia dc")
        }
        return a/b
    }
}