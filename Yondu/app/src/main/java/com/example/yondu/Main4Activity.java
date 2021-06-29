package com.example.yondu;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Main4Activity extends AppCompatActivity {

    private View mainview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mainview = findViewById(R.id.button1);
    }

    public void onClickSnack(View view) {

        Snackbar.make(mainview,"더 이상 접근할 수 없습니다", Snackbar.LENGTH_INDEFINITE)
                .setAction("Good!", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
    }

}
