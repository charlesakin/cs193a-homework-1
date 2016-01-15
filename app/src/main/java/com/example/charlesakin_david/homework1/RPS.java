package com.example.charlesakin_david.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.util.Random;

public class RPS extends AppCompatActivity {

    private int points = 0;
    private Random ran = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
    }


    /*
    * This method is called when the user clicks one of the radio buttons.
    * It sets the onscreen ImageView to display the relevant hand. It also
    * randomly chooses the hand to display for the computer. Then it calculates
    * the user's score depending on the hand configurations.
    */
    public void choice(View view) {
        int id = view.getId();
        int comp = ran.nextInt(3);
        ImageView imgComp = (ImageView) findViewById(R.id.computer);
        if (comp == 0) imgComp.setImageResource(R.drawable.lrock);
        if (comp == 1) imgComp.setImageResource(R.drawable.lpaper);
        if (comp == 2) imgComp.setImageResource(R.drawable.lscissors);
        ImageView img = (ImageView) findViewById(R.id.human);
        TextView resultView = (TextView) findViewById(R.id.result);
        if (id == R.id.rock) {
            img.setImageResource(R.drawable.rock);
            if (comp == 1) {
                points--;
                resultView.setText("You Lose! :(");
            }
            else if (comp == 2) {
                points++;
                resultView.setText("You Win! :D");
            }
            else {
                resultView.setText("Its a tie! :/");
            }
        } else if (id == R.id.paper) {
            img.setImageResource(R.drawable.paper);
            if (comp == 2) {
                points--;
                resultView.setText("You Lose! :(");
            }
            else if (comp == 0) {
                points++;
                resultView.setText("You Win! :D");
            }
            else{
                resultView.setText("Its a tie! :/");
            }
        } else {
            img.setImageResource(R.drawable.scissors);
            if (comp == 0) {
                points--;
                resultView.setText("You Lose! :(");
            }
            else if (comp == 1) {
                points++;
                resultView.setText("You Win! :D");
            }
            else {
                resultView.setText("Its a tie! :/");
            }
        }

        TextView pointView = (TextView) findViewById(R.id.points);
        pointView.setText("Points: " + points);
    }
}
