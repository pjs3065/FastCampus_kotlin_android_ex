package com.example.parkjs.myapplication.step1

import com.example.parkjs.myapplication.TestClass

class ExceptionTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        var divNumber = 0

        try {
            707 / divNumber
        } catch (e: Exception) {
            println(e)
        } finally {
            println("Last")
        }

        var addNumber: Int? = null

        //첫번째 null point 에러 막는 법
        if (addNumber != null) {
            var sum = addNumber + 100
        }

        //두번째 (!!을 쳣허 죽는 방법)
        //var sum = addNumber!! + 100


        //세번째 (let을 사용)
        var sum = addNumber?.let { it + 100 }
    }
}