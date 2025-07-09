package com.example.ggsouresjetpack.Decorator

import androidx.lifecycle.ViewModel

class Context: ViewModel() {
  private lateinit var tinhtoan: Tinh
    fun setTinhToan(tinhToan: Tinh): Unit{
        this.tinhtoan=tinhToan
    }
    fun tinh(a: Float, b: Float): Float{
        if(!::tinhtoan.isInitialized){
            throw ( IllegalArgumentException(" KHONG The TInh")) as Throwable;
        }
        return tinhtoan.tinh(a,b)
    }
}