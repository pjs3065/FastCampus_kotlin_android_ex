package com.example.parkjs.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.parkjs.myapplication.step2.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 우리가 만든 에제를 이곳에서 실행시킨다.
        //doTest(FirstTest(::WriteLn))
        //doTest(NumberTest(::WriteLn))
        //doTest(StringTest(::WriteLn))
        //doTest(AnyTest(::WriteLn))
        //doTest(FunctionTest(::WriteLn))
        //doTest(ConditionTest(::WriteLn))
        //doTest(LabelTest(::WriteLn))
        //doTest(CollectionTest(::WriteLn))
        //doTest(ExceptionTest(::WriteLn))
        //doTest(ClassTest(::WriteLn))
        //doTest(PolymorphTest(::WriteLn))
        //doTest(InterfaceAbstractTest(::WriteLn))
        //doTest(DataClassTest(::WriteLn))
        doTest(ObjectTest(::WriteLn))
    }

    private fun doTest(o: TestClass) {
        o.doTest()
    }

    fun WriteLn(any: Any) {
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}
