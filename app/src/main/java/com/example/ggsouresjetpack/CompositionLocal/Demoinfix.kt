package com.example.ggsouresjetpack.CompositionLocal

class DemoInfix {

    fun login(){
        val check = CheckEmail()
        check.check("x@t.com")

        check check "321"
    }

}
class CheckEmail{
    infix fun check(email: String){

    }
}