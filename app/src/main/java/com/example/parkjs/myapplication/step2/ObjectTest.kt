package com.example.parkjs.myapplication.step2

import com.example.parkjs.myapplication.TestClass

class ObjectTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {

        // 1. 클래스 전체를 싱글톤으로 사용할 때, 마치 java의 static class
        SingleTon.showMessage("싱글톤 입니다.")

        val obj = StaticTest()
        println(obj.msg)

        // 2. companion object (특정 부분만 static)
        println(StaticTest.staticVar)
        StaticTest.staticFunc()

        // 3. Android에서 자주사용됨
        var obj2 = object : fakeClickHandler() {
            override fun onClick() {
                println("click!!")
            }
        }

        obj2.onClick()
    }

    object SingleTon {
        var showMessage = { msg: String -> println(msg) }
    }

    class StaticTest {
        var msg: String = "일반객체로 생성하면 이 변수를 액세스 가능함"

        // companion object {} 안에서 구현해야 static 가능
        companion object {
            var staticVar = "StaticTest.staticVar"
            fun staticFunc() = println("StaticTest.staticFunc")
        }
    }

    // 누군가 객체로 만들면 onClick을 반드시 구현해야한다.
    abstract class fakeClickHandler {
        abstract fun onClick()
    }
}