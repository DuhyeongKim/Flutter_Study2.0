package com.example.yondu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ArrayList<String> data = new ArrayList<String>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        data.add(new String("퉤퉤"));
        data.add("peng");
        data.add("peng2");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listView = findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                display(data.get(position) + " ");

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                delteOk(position);
                return false;
            }
        });

    }
    private  void delteOk(int position){
        Toast.makeText(this, "삭제되었습니다", Toast.LENGTH_LONG).show();
    }
    public void display(String data){
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();

    }
}
