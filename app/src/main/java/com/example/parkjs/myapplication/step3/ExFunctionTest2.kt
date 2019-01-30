package com.example.parkjs.myapplication.step3

import com.example.parkjs.myapplication.TestClass

class ExFunctionTest2(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // 1. 이미 정의된 클래스에 확장함수
        // String클래스에 myFunction을 만들었다. (scope 밖으로 나갈 시 사용 불가능)

        fun String?.myFunction(s: String, n: Int): String? {
            var sTooManyTalk = "$this : added \n"
            (1..n).forEach { sTooManyTalk += "${s}\n" }
            return sTooManyTalk
        }

        println("hi".myFunction("Hi", 10))

        //2. 파라메터로 확장함수 -> 객체에서 실행

        val obj = ani {
            crying()
            eat()
            nCount++
        }

        val obj2 = ani(3) {
            crying()
            eat()
            nCount += it
        }

        println("증가된 숫자는 ${obj.nCount} 입니다.");

        obj2.setOnEvent(3, "울어") { nCount ->
            println("${nCount}번 울겠습니다.")
            (1..nCount).map { crying() }
        }

        obj2.setOnEvent(2, "먹어") { nCount ->
            println("${nCount}번 먹겠습니다.")
            (1..nCount).map { eat() }
        }


        //(apply와의 차이점은?)
        //3. 객체 멤버 접근해보기 (val)
        //4. 안드로이드에서 흔하게 보게 될 코드(interface와 함께)
    }

    fun ani(extFunc: Animal.() -> Unit): Animal //Animal 객체의 파라미터 없고, 객체가 없는 메소드형을 만들어 놓았다.
    {
        var ani = Animal()

        //매우 중요함
        ani.extFunc()
        return ani
    }

    fun ani(n: Int, extFunc: Animal.(Int) -> Unit): Animal {
        var ani = Animal()

        ani.extFunc(n)
        return ani
    }


    class Animal {
        open var nCount = 0
        fun crying() = println("$this>> 아흥")
        fun eat() = println("$this>> 우걱우걱")

        open fun setOnEvent(nCount: Int, message: String, extFunc: Animal.(Int) -> Unit): Animal {
            when (message) {
                "울어" -> {
                    extFunc(nCount)
                }
                "먹어" -> {
                    var n = if (nCount < 3) 4 else nCount; extFunc(n)
                }
                else -> {
                    println("알수없는 메시지: ${message} 입니다.")
                }
            }
            return this
        }
    }
}