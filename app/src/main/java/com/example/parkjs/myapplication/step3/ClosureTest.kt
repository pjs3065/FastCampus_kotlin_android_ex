package com.example.parkjs.myapplication.step3

import com.example.parkjs.myapplication.TestClass

class ClosureTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {

        var fn = Closure1(10)

        println(fn(10))
        println(fn(10))
        println(fn(10))
        println(fn(10))

        var decByOne = Closure2({ num -> num - 1 })
        println(decByOne())
        println(decByOne())

        fun Add(num: Int) = num + 10
        var addByTen = Closure2(::Add)
        println(addByTen())
        println(addByTen())

    }

    fun Closure1(num: Int): (Int) -> Int {
        var sum: Int = num

        return fun(num2: Int): Int {
            sum += num2
            return sum
        }
    }

    fun Closure2(pFunc: (Int) -> Int): () -> Int {
        var result: Int = 0

        return {
            result = pFunc(result)
            result
        }
    }
}