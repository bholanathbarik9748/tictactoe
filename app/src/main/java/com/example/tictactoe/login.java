package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.lang.Thread.sleep;
//go to another page!!!!
public class login extends AppCompatActivity {
    private Button button4;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       button4 =(Button) findViewById(R.id.button4);
       button4 .setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openreg();
           }
       });

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gamepage();
            }
        });
    }
    public void openreg() {
        Intent intent = new Intent(this,  register.class);
        startActivity(intent);
    }

    public void gamepage() {
        Intent intent = new Intent(this,  gamepage.class);
        startActivity(intent);
    }



    //exit massage!!!

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are your sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("yes",new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        login.super.onBackPressed();

                    }
                })

          .setNegativeButton("No" , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}



