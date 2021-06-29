package com.example.yondu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yondu.ui.Animal;

import java.util.ArrayList;

public class Animal2Activity extends AppCompatActivity {
    ArrayList<Animal> data = new ArrayList<>();
    Animal2Adapter adapter;
    RecyclerView recyclerView;
    Button btnAdd, btnDel;
    EditText editText;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal2);

        initRecyclerView();
    }

    void initRecyclerView() {
        editText = findViewById(R.id.edit1);
        btnAdd = findViewById(R.id.button1);
        btnDel = findViewById(R.id.button2);

        loadData();
        setListView();
    }

    private void setListView() {
        adapter = new Animal2Adapter(this, data);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    private void loadData() {
        data.add(new Animal(R.drawable.it, "가전주부", "it"));
        data.add(new Animal(R.drawable.peng2, "펭수", "엣헴엣헴"));
    }

    public void onButton(View view) {
        Toast.makeText(this, "가전주부로 이동합니다",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.youtube.com"));
        startActivity(intent);
    }

    public void onClick2(View view) {
        Toast.makeText(this, "추천 컨텐츠1로 이동합니다.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=oEB54AcMJ6Q"));
        startActivity(intent);
    }

    public void onClick1(View view) {
        Toast.makeText(this, "연관 검색어로 이동합니다.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?where=nexearch&query=%EC%B5%9C%EC%84%9C%EC%98%81&ie=utf8&sm=tab_she&qdt=0"));
        startActivity(intent);
    }
    public void onClick4(View view) {
        Toast.makeText(this, "추천 컨텐츠2로 이동합니다.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=oEB54AcMJ6Q"));
        startActivity(intent);
    }

    public void onClick3(View view) {
        Toast.makeText(this, "위키로 이동합니다.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%ED%8E%AD%EC%88%98"));
        startActivity(intent);
    }
    public void onClick6(View view) {
        Toast.makeText(this, "추천 컨텐츠3로 이동합니다.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=oEB54AcMJ6Q"));
        startActivity(intent);
    }

    public void onClick5(View view) {
        Toast.makeText(this, "프로필로 이동합니다.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EC%88%98%EB%B9%99%EC%88%98&oquery=%ED%8E%AD%EC%88%98&tqi=Ur1sTwprvOssskpLm5lssssssI4-192732"));
        startActivity(intent);
    }
}

