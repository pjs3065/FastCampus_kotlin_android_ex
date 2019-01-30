package com.example.parkjs.myapplication.step3

import com.example.parkjs.myapplication.TestClass

class ExFunctionTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // let
        f1().let { value -> println(value) }
        f1().let { 값 -> println(값) }
        1232.let { it + 1 }.let { it * 3 }.let { println(it) }

        var add = { a: Int, b: Int -> a + b }
        add(1, 2).let { println(it) }

        var bug: () -> Any? = { null }
        bug()?.let { println(it) } // ?.let의 경우 null이 아닐 경우에 뒤에 것을 실행해라 (null 처리에 용이)

        // apply()
        val obj = Test().apply { sName = "박모씨"; nAge = 49 } //객체 생성과 동시에 초기화 하기 위해서 사용된다.
        obj.aboutMe()

        // run()
        obj.run { sName = "김모씨"; aging(); sName }.let { println(it) }

        // 실행결과를 리턴
        run { 333 + 4 }.let { println(it) } //run은 어떤 값을 변수 없이 안전하게 넘길때 사용한다.

        //also
        100.let { println(it); it } // 100을 넘겨서 출력
            .also { println(it + 1000) } // let으로 받은 것을 also로 100을 넘김
            .also { println(it + 20) } // also의 값을 넘기는 것이 아닌 100을 넘김
            .let { println(it) } // also의 값을 넘기는 것이 아닌 100을 넘김
    }

    fun f1() = 10
    class Test {
        var sName: String = "무명씨"
        var nAge: Int = 49
        fun aboutMe() = println("이름은 \"$sName\"이고 나이는 $nAge 입니다. ")
        fun aging() = nAge++
    }
}