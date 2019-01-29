package com.example.parkjs.myapplication.step1

import com.example.parkjs.myapplication.TestClass

class CollectionTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        val list = listOf(1, "A", 12.00f, false, true)
        //val list2 = listOf <Int> (1, "A", 12.00f, false, true) // 오류

        for (i in 0..list.size - 1) {
            println(list.get(i).toString())
        }

        println(">")

        var lstEditable = mutableListOf<String>()

        lstEditable.add("a")
        lstEditable.add("b")
        lstEditable.add("c")
        lstEditable.add("d")
        lstEditable.add("e")

        for (s in lstEditable) {
            println(s)
        }

        println(">")

        lstEditable.removeAt(0)
        for (s in lstEditable) {
            println(s)
        }

        // 키값 과 벨류를 넣는다.
        var m = hashMapOf("A" to 1, "B" to 2)
        println(m["A"])
    }
}