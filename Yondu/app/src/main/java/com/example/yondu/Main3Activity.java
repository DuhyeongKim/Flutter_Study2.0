package com.example.yondu;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    RadioButton r1, r2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout3);

        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        imageView = findViewById(R.id.imageView3);

        r1.setOnCheckedChangeListener(this);
        r2.setOnCheckedChangeListener(this);
/*
        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) imageView.setImageResource(R.drawable.peng);
            }
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) imageView.setImageResource(R.drawable.peng2);
            }
        });

 */

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            // Log.d();
            if (buttonView == r1) {
                imageView.setImageResource(R.drawable.peng);
            } else if (buttonView == r2) {
                imageView.setImageResource(R.drawable.peng2);
            }
        }
    }
}
