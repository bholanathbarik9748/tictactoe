package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class gamepage extends AppCompatActivity {
    boolean gameActive = true;
    int activiteplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};

    int[][] winposition = {{0,1,2},{3,4,5},{4,5,6},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            gamereset(view);
        }
        if(gamestate[tappedimage] == 2 && gameActive) {
            gamestate[tappedimage] = activiteplayer;
            img.setTranslationY(-1000f);
            if (activiteplayer == 0) {
                img.setImageResource((R.drawable.x));
                activiteplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("player O tap to play");

            } else {
                img.setImageResource((R.drawable.o));
                activiteplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("player X tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(1000);
        }
        for (int[] winposition : winposition) {
            if (gamestate[winposition[0]] == gamestate[winposition[1]] && gamestate[winposition[1]] == gamestate[winposition[2]] && gamestate[winposition[0]] != 2){
                String win;
                if (gamestate[winposition[0]] == 0){
                   win = "X you win";
                }
                else {
                     win = "O you win";
                }
                TextView status = findViewById(R.id.status);
                status.setText(win);
            }
        }
    }

    private void gamereset(View view){
        gameActive = true;
        activiteplayer =0;
        for (int i = 0 ; i<gamestate.length;i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamepage);


    }

}