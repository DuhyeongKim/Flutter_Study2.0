package com.example.yondu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CustomDialogActivity extends AppCompatActivity {
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
    }

    private void dialog4(){
        View view = View.inflate(this, R.layout.activity_custom_dialog, null);
        e1 = view.findViewById(R.id.edit1);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("radio 대화 상자")
                .setIcon(R.mipmap.ic_launcher_round)
                .setView(view)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            addAnimal();

                        }else if(which == 1){

                        }
                        //Toast.makeText(this, "삭제되었음!",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("ok", null)
                .show();

    }
    private void addAnimal(){
        Toast.makeText(this, e1.getText().toString(), Toast.LENGTH_LONG).show();
    }
    private void dialog1() {
        String animal[] = {"bear", "lion"};
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("radio 대화 상자")
                .setIcon(R.mipmap.ic_launcher_round)
                .setSingleChoiceItems(animal, 1, null)
                .setPositiveButton("no Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            delete1(which);

                        }else if(which == 1){

                        }
                        //Toast.makeText(this, "삭제되었음!",Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("cancel", null)
                .show();

    }
    private void delete1(int which){
        Toast.makeText(this, "Bear이 선택되었음!",Toast.LENGTH_LONG).show();
    }
}
