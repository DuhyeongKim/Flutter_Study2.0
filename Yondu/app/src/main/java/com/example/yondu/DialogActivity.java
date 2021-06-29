package com.example.yondu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {
    String animal[] = {"bear", "lion"};
    final boolean checked[] = {true, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onClick(final View view) {
        if (view.getId() == R.id.button10) {
            dialog1();
        }else if(view.getId() == R.id.button13){
            dialog2();

        }

            //data.remove(position);
        //adapter.noti

    }
    private void dialog2() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("CHECK BOX")
                .setIcon(R.mipmap.ic_launcher_round)
                .setMultiChoiceItems(animal, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which] = isChecked;
                        if(which == 0){
                            delete1(which);
                        }else if(which == 1){
                            delete2(which);
                        }
                    }
                })

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
                .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i =0 ; i<animal.length; i++){
                            if (checked[i]){
                                String data = animal[i];
                            }
                        }
                    }
                })
                .show();

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
                .setNegativeButton("ok", null)
                .show();

    }
    private void delete1(int which){
        Toast.makeText(this, "Bear이 선택되었음!",Toast.LENGTH_LONG).show();
    }
    private void delete2(int which){
        Toast.makeText(this, "Liond이 선택되었음!",Toast.LENGTH_LONG).show();
    }
    private void delete3(int which){
        Toast.makeText(this, "Liond와 Bear가 선택되었음!",Toast.LENGTH_LONG).show();
    }
    private void delete4(int which){
        Toast.makeText(this, "아무것도 선택되지 않음",Toast.LENGTH_LONG).show();
    }
    //private void
}

