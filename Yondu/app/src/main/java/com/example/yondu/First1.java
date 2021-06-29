package com.example.yondu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class First1 extends AppCompatActivity {

    String[] words = new String[] {"hello","java","Jang"};
    String[] words2 = new String[] {"hello2","java2","Jang2"};
    String[] words3 = new String[] {"hello3","java3","Jang3"};
    String text1 = "공무원 영단어";
    String text2 = "수능필수 영단어";
    String text3 = "나만의 영단어";
    final static int REQUESST = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void onClck1(View view) {
       // Toast.makeText(this, "하하하",Toast.LENGTH_SHORT).show();
        //String msg = tv.getText().toString();
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("msg", words);
        intent.putExtra("msg3", text1);
        startActivity(intent);

    }

    public void Col(View view) {
        //String msg = tv1.getText().toString();
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("msg", words2);
        intent.putExtra("msg3", text2);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUESST){
            if(requestCode == RESULT_OK){
                String msg2 = data.getStringExtra("msg2");
                //tv.setText(msg2);
            }
        }
    }

    public void onClck2(View view) {
        //String msg = tv1.getText().toString();
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("msg", words3);
        intent.putExtra("msg3", text3);
        startActivity(intent);
    }
}
