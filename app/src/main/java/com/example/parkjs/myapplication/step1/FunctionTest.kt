package com.example.parkjs.myapplication.step1

import com.example.parkjs.myapplication.TestClass

class FunctionTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {

        funByNoParam()
        funByParameter(31, " 숫자입니다")
        println(funByReturn("Parameter"))
        println(funByInline(31, 10))

        funVar("Function Variable 1")
        println(funcVarType("Function Variable 2"))

        HigherFunc({ println("Higher Function") })
        HigherFunc(::funByNoParam)
    }

    fun funByReturn(s: String): Any? {
        return s
    }

    fun funByParameter(i: Int, s: String) {
        println(i.toString() + s)
    }

    fun funByInline(i: Int, i1: Int) = i * i1

    fun funByNoParam() {
        println("funByNoParam")
    }


    //함수를 넘겨주고 함수를 넘겨 받는 것을 고차원 함수라고 한다.
    fun HigherFunc(f: () -> Unit) {
        f()
    }

    val funVar = { s: String -> println(s) }

    // ::은 함수의 주소값을 넘긴다는 이야기이다.
    var funcVarType: (String) -> Any? = ::funByReturn
}