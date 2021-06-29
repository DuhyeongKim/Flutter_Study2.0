package com.example.yondu;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {

    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        init();

    }
    private void init(){
        b1.findViewById(R.id.btnSave1);
        //b1.setOnClickListener(this);
        b2.findViewById(R.id.btnSave2);
        //b2.setOnClickListener(this);
    }

    private void readRawFile(){
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader br = new BufferedReader((new InputStreamReader(is)));
        String str = null;
        String content = "";

        /*try{
            while((str = br.readLine() != null)){
                content += str;
            }
        }*/


    }

   /* private void saveFile(){
        String filename = getFilesDir() + "data.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write("hello!@!\n");
            bw.write("hello!@!\n");
            bw.close();
            Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();
        }catch (IOException e){
            e.printStackTrace();
        }
        }
        private void readFile(){
        try {
                String str = null;
                String content = "";
                BufferedReader br = new BufferedReader(new FileWriter(filename));
                while((str = br.readLine()) != null){
                    content += str;
                }
                br.close();
                Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }*/
}
