package com.example.ggsouresjetpack.Example

import androidx.lifecycle.ViewModel
import kotlin.random.Random


class RandomViewModel(): ViewModel(){
    fun randomList(): String{
        val Dssv = listOf("Phùng Quốc Thịnh","Mai Thị My Sa","Lý Ngọc Long","La Phong","Lâm Phong")
        val index = Random.nextInt(0,4)
        return Dssv[index]
    }
}