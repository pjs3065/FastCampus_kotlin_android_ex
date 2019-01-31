package com.example.parkjs.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.parkjs.myapplication.step3.*
import com.example.parkjs.myapplication.step4.InfixTest
import com.example.parkjs.myapplication.step4.LateTest
import com.example.parkjs.myapplication.step4.MultiRetunTest
import com.example.parkjs.myapplication.step4.PropertiesTest
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
        //doTest(ObjectTest(::WriteLn))
        //doTest(LambdaTest(::WriteLn))
        //doTest(ExFunctionTest(::WriteLn))
        //doTest(ClosureTest(::WriteLn))
        //doTest(ExFunctionTest2(::WriteLn))
        //doTest(DSLTest(::WriteLn))
        //doTest(CurringTest(::WriteLn))
        //doTest(InfixTest(::WriteLn))
        //doTest(MultiRetunTest(::WriteLn))
        //doTest(LateTest(::WriteLn))
        doTest(PropertiesTest(::WriteLn))
    }

    private fun doTest(o: TestClass) {
        o.doTest()
    }

    fun WriteLn(any: Any) {
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}
