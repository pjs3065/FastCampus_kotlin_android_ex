package com.example.parkjs.myapplication.step2

import com.example.parkjs.myapplication.TestClass

class ClassTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        Test1().showInfo()
        Test1("PSW", 10)
        Test2("나다").showInfo()
        Test2("PSW", 10)

        ChildClass("HI").sayHello()
    }

    class Test1 {
        var sName: String = "Test1"
        var nAge: Int = 10

        constructor() {
            println(this.toString())
        }

        constructor(name: String, age: Int) {
            sName = name
            nAge = age
        }

        fun showInfo() = println("${sName} : ${nAge}")
    }

// 생성자를 ()로 처리하는 클래스
// 클래스에서 다른 생성자를 정의하려면
// constructor뒤에 : this(정의한 값)을 덛붙힌다.

    class Test2(name: String) {
        var sName: String = "Test2"
        var nAge: Int = 10

        //초기화 먼저 실행
        init {
            sName = name
        }

        constructor(name: String, age: Int) : this(name) {
            sName = name
            nAge = age
        }

        fun showInfo() = println("${sName} : ${nAge}")
    }

    //상속을 시키려면 open을 꼭 사용해야한다.
    open class ParentClass(msg: String) {
        var message = msg
        fun sayHello() = println(message)
    }

    class ChildClass(m: String) : ParentClass(m)
}
