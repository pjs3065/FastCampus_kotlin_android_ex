package com.example.parkjs.myapplication.step4

import com.example.parkjs.myapplication.TestClass

class MultiRetunTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        //destructuring (multi value return)
        // 우측의 값을 좌측의 변수로 나누어 순서대로 대입하는 것

        // 1. ()안에 변수를 나열한다.
        //... 일반적으로 Data class, List, Pair Collection의 반환값
        //... 순서대로 특정범위까지 가져올 수 있다.

        //list의 경우
        val (v1, v2, v3) = listOf("Kotlin", 32, 123.0f)
        println("$v1, $v2, $v3")

        //data class일 경우
        val (name, grade) = StudentA("name", 32)


        // 2 List 파티션으로 나누기
        val lst = (0..10).map { StudentA("name - ${it}", (it % 3) + 1) }
        println(lst)

        val (l1, l2) = lst.partition { it.grade == 2 }

        println("l1")
        l1.map { println(it) }

        println("l2")
        l2.map { println(it) }

        // 3. 순위별로 가져오기
        // 0부터 100까지 중에서 2로 나눠지는 것을 골라서 소팅을 한다.
        val (n1, n2, n3) = (0..100)
            .filter { it % 2 == 0 }
            .sortedByDescending { it }

        //3위 까지 가져오기
        println(n1.toString() + ", " + n2.toString() + ", " + n3.toString())
    }

    data class StudentA(var name: String, var grade: Int)

    //일반 클래스는 사용이 불가능하다.
    class StudentB() {
        var name: String = ""
        var grade: Int = 0
    }
}