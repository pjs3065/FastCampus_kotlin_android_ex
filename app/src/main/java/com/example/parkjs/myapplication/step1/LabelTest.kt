package com.example.parkjs.myapplication.step1

import com.example.parkjs.myapplication.TestClass

class LabelTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        ExitLoop()
        println(lambaReturn().toString())

        //람다식
        (0..10).forEach { if (it > 3) return@forEach else println(it) }
    }

    fun ExitLoop() {
        HereToExit@ for (i in 0..2) {
            for (j in 0..10) {
                if (j == 5) break@HereToExit
                println("i -> $i, j -> $j")
            }
            println("j loop end")
        }
        println("i loop end")
    }

    var lambaReturn = Exit@{
        if (true) {
            return@Exit 3
        }
        1000
    }
}