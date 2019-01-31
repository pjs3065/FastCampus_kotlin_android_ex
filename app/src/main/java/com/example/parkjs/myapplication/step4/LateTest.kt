package com.example.parkjs.myapplication.step4

import com.example.parkjs.myapplication.TestClass
import kotlin.random.Random

class LateTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        var l = LateInitTest()
        l.Test()

        var l2 = LazyInitTest()
        l2.Test()
    }

// 코틀린에서는 java와 달리 멤버필드를 반드시 초기화해야 한다.
// 아니면 abstract나 lateinit으로 선언해주어야 한다.

    // 1. var만 사용가능.
// 2. 늦은초기화이므로 초기화전에 사용불가
// 3. primitive 형은 불가능함.
    class LateInitTest {
        var normalValue: Int = 3
        var initTest: Int


        //initTest가 생성되자마자 초기화 하기 때문에 오류가 안뜬다.
        init {
            initTest = 0
        }

        //어디선가 나는 초기화 할 것이다
        lateinit var late: String

        fun Test() {
            this.late = "lateinit 초기"
            println(this.late)
        }

    }

//lazy의 경우 메모리 효율로 많이 사용된다.
// 1. val로 선언
// 2. 사용하는 시점에서 초기화가 1회 발생
// 3. primitive 형도 가능

//화면 관련된 무거운 객체를 선언할 때 많이 사용된다.

    class LazyInitTest {
        //lazy1을 실행하는 순간 lazy를 이용해서 초기화 해준다.
        val lazy1: String by lazy {
            "lazyinit 초기화"
        }

        //일반적으론 이렇게 쓴다.
        //한번만 실행된다.
        val lazy2: Int by lazy {
            println("1번만 실행")
            Random.nextInt(100)
        }

        fun Test() {
            println(lazy1)
            println(lazy2)
            println(lazy2)
        }
    }
}