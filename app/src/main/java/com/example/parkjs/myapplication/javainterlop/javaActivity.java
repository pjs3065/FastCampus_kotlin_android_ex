package com.example.parkjs.myapplication.javainterlop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.parkjs.myapplication.R;

import static com.example.parkjs.myapplication.javainterlop.KotlinActivityKt.kotlinEventHandler;

public class javaActivity extends AppCompatActivity {

    String sMessage = "Hi, Java";

    //kotlin에서 사용할 것이다.
    public void T(Context ctx, String sMessage)
    {
        Toast.makeText(ctx, sMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        //코틀린으로 만든 확장함수 사용하기
        kotlinEventHandler(this);

        //코틀린 파일에서
        usingKotlin();
    }

    private void usingKotlin()
    {
        // Kotlin 가져오기
        // class가 아닌 변수와 함수는 자동으로 변환한다.
        // 파일명을 대소문자 변경 후, 뒤에 Kt를 붙인다.
        // 그리고 . 연산자 이후에 사용가능

        KotlinActivityKt.getName();
        KotlinActivityKt.MyTest();

        //클래스명은 그대로 사용 가능하다.
        // 어노테이션으로 자바에서 사용할 것을 지정해주어야 한다.
        Log.d("TEST",KotlinExport.name);

        KotlinExport.age = 30;
        KotlinExport.test();

        KotlinExport ke = new KotlinExport();
        ke.test2();
    }
}
