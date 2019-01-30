package com.example.parkjs.myapplication.step3

import com.example.parkjs.myapplication.TestClass
import kotlin.random.Random

class DSLTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        //1. 반복되고 제한된 환경을 위한 간이 언어
        //2. 확장함수를 이용한다.

        var p0 = Player()
        p0.name = "Player0"
        p0.status = Status()
        p0.status!!.job = "Wizard"
        p0.status!!.level = 20
        println(p0)

        //위의 것을
        //data class로 정의
        val p1 = Player("Player1", Status("Archer", 23))

        val p2 = MakePlayer {
            name = "Player2 - " + Random.nextInt(200).toString()
            status {
                job = "Paladin"
                level = Random.nextInt(70)
            }
        }

        println(p2)


    }

    fun MakePlayer(block: Player.() -> Unit): Player {
        return Player().apply(block)
    }

    fun Player.status(block: Status.() -> Unit) {
        status = Status().apply(block)
    }

    data class Player(var name: String? = null, var status: Status? = null)


    data class Status(var job: String? = null, var level: Int? = null)
}