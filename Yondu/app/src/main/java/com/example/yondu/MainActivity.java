package com.example.yondu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /*
    1 아메리카노 갯수
    2 할인여부
    3 가격계산
    4 메시지창 - 버튼을 누를 때 이벤트가 일어나야 함
     */
    //alt enter 자동 import
    Button b1,b2,b3,b4;
    EditText e1;
    CheckBox c1;
    //TextView t1;

    //onCreate가 항상 제일 먼저 실행된다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //parent의 함수먼저 실행
        super.onCreate(savedInstanceState);
        //r.layout(activity_main)을 세팅하겠다
        setContentView(R.layout.activity_main);

    }

        //t1 = findViewById(R.id.textView2);
        public void onClickToast(View view) {
            display("hello");

        }
        public void display(String s){

            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        }

        public void onClickCount(View view) {


        }

        /*
        //이벤트를 걸어야 하는건 아래처럼 다 해야 함.
        b1 = findViewById(R.id.button4);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);
        e3 = findViewById(R.id.edit3);
        c1 = findViewById(R.id.checkBox);
        // call back method 만 구현하면 알아서 os가 일함
        c1.setOnCheckedChangeListener(new View.);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. edit date 가져오기
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                String str3 = e3.getText().toString();

                //2. msg 창 띄우기

                Toast.makeText(MainActivity.this, str1, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, str2, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, str3, Toast.LENGTH_SHORT).show();


            }
        });*/ // 파라미터로 인터페이스구현


}
