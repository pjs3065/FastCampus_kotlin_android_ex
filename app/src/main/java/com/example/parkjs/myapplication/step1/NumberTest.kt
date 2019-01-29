package com.example.parkjs.myapplication.step1

import com.example.parkjs.myapplication.TestClass

class NumberTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        var doubleV: Double = 110.1111
        var floatV: Float = 110.0f // f를 빼면 에러이다.
        var longV: Long = 110
        var intV: Int = 20
        var shortV: Short = 30
        var byteV: Byte = 10

        println(doubleV)
        println(floatV)
        println(longV)
        println(intV)
        println(shortV)
        println(byteV)


        //숫자형 문자형 같은 경우 as로 캐스팅이 불가하다.
        doubleV = intV.toDouble() // intV as Double는 캐스팅 하지 못한다.
        intV = doubleV.toInt()

        println(byteV.toString())

        val num = "123".toInt() + 10
        println(num)
    }
}
