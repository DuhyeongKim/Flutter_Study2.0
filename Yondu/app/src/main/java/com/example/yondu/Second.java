package com.example.yondu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    EditText t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        t1 = findViewById(R.id.Text1);
        t2 = findViewById(R.id.textView3);
        String[] msg = intent.getStringArrayExtra("msg");
        String title = intent.getStringExtra("msg3");
        t1.setText(String.join("\n", msg));
        t2.setText(title);

    }

    public void onClick(View view) {
        finish();
    }

    public void Go(View view) {
        finish();
    }
}
