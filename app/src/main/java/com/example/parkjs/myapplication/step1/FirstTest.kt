package com.example.parkjs.myapplication.step1

import com.example.parkjs.myapplication.TestClass

class FirstTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        println("종결자(;)없어도 됩니다. ")
        println("var는 읽기쓰기. val는 읽기전용")

        var nCount: Int = 0
        var name = "psw"

        val age = 0
        //age++

        var MyMoney: Int? = null
        var message = "위에서는 액세스 불가함"

        println(hiMessage)
    }

    val hiMessage: String = "Hi" //멤버변수로 인식하기에 위에서 출력이 가능하다.
}