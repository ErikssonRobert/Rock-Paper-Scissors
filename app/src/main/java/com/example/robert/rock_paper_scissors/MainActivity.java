package com.example.robert.rock_paper_scissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Option userSelection = null;
    Option aiSelection = null;
    Result gameResult = null;
    int playerScore = 0;
    int aiScore = 0;
    String playerHistory = "";
    String aiHistory = "";



    public void buttonOnClick1(View l){
        ImageView imageView1 = (ImageView) findViewById(R.id.playerHand);
        userSelection = Option.ROCK;
        imageView1.setImageResource(R.drawable.rock);
        checkHistory();
        aiSelect();
        compare();
        getPoint();
        playerHistory = "rock";
    }

    public void buttonOnClick2(View ll){
        ImageView imageView1 = (ImageView) findViewById(R.id.playerHand);
        userSelection = Option.PAPER;
        imageView1.setImageResource(R.drawable.paper);
        checkHistory();
        aiSelect();
        compare();
        getPoint();
        playerHistory = "paper";
    }

    public void buttonOnClick3(View lll){
        ImageView imageView1 = (ImageView) findViewById(R.id.playerHand);
        userSelection = Option.SCISSORS;
        imageView1.setImageResource(R.drawable.scissors);
        checkHistory();
        aiSelect();
        compare();
        getPoint();
        playerHistory = "scissors";
    }

    public void checkHistory(){
        ImageView imageView3 = (ImageView) findViewById(R.id.playerHandHistory);
        ImageView imageView4 = (ImageView) findViewById(R.id.aiHandHistory);
        if(playerHistory.equals("rock")){
            imageView3.setImageResource(R.drawable.rock);
        }
        else if(playerHistory.equals("paper")){
            imageView3.setImageResource(R.drawable.paper);
        }
        else if(playerHistory.equals("scissors")) {
            imageView3.setImageResource(R.drawable.scissors);
        }

        if(aiHistory.equals("rock")){
            imageView4.setImageResource(R.drawable.rock2);
        }
        else if(aiHistory.equals("paper")){
            imageView4.setImageResource(R.drawable.paper2);
        }
        else if(aiHistory.equals("scissors")){
            imageView4.setImageResource(R.drawable.scissors2);
        }
    }

    public void getPoint(){
        if (gameResult == Result.WIN){
            playerScore++;
            TextView score1 = (TextView)findViewById(R.id.textView4);
            score1.setText("" + playerScore);
            TextView resultText = (TextView)findViewById(R.id.resultView);
            resultText.setText("You win!");
        }
        else if (gameResult == Result.LOSS){
            aiScore++;
            TextView score2 = (TextView)findViewById(R.id.textView5);
            score2.setText("" + aiScore);
            TextView resultText = (TextView)findViewById(R.id.resultView);
            resultText.setText("You lose!");
        }
        else{
            TextView resultText = (TextView)findViewById(R.id.resultView);
            resultText.setText("Draw!");
        }
    }

    public void aiSelect(){
        int rand = ((int)(Math.random() * 3+1));
        ImageView imageView2 = (ImageView) findViewById(R.id.aiHand);

        switch (rand){
            case 1:
                aiSelection = Option.ROCK;
                imageView2.setImageResource(R.drawable.rock2);
                aiHistory = "rock";
                break;
            case 2:
                aiSelection = Option.PAPER;
                imageView2.setImageResource(R.drawable.paper2);
                aiHistory = "paper";
                break;
            case 3:
                aiSelection = Option.SCISSORS;
                imageView2.setImageResource(R.drawable.scissors2);
                aiHistory = "scissors";
                break;
        }
    }

    public void compare() {
        if (aiSelection == userSelection) {
            gameResult = Result.DRAW;
        } else if (aiSelection == Option.ROCK && userSelection == Option.SCISSORS) {
            gameResult = Result.LOSS;
        } else if (aiSelection == Option.PAPER && userSelection == Option.ROCK) {
            gameResult = Result.LOSS;
        } else if (aiSelection == Option.SCISSORS && userSelection == Option.PAPER) {
            gameResult = Result.LOSS;
        } else {
            gameResult = Result.WIN;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
