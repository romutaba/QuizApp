package com.example.omutaba.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //global variable declaration and initialization
    int score = 0;
    public EditText answerOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerOne = (EditText) findViewById(R.id.answerQ1);
        final Button scoreButton = (Button) findViewById(R.id.resultBtn);
        scoreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if(isValid(answerOne.getText().toString())){
                    score ++;
                }
                if (((CheckBox) findViewById(R.id.checkbox_marshmallow)).isChecked()){score++;}
                if (((CheckBox) findViewById(R.id.checkbox_Nougat)).isChecked()){score++;}
                if (((RadioButton)findViewById(R.id.radio_res)).isChecked()) {score++;}
                if (((RadioButton)findViewById(R.id.radio_java1)).isChecked()) {score++;}

                //call the displayReport method to display results
                displayReport(score);

                //disable score button
                scoreButton.setEnabled(false);
            }

        });
    }
    /**
     * method to validate user input for answer one
     * @param androidVer
     * @return
     * */
    public boolean isValid(String androidVer) {
        //condition to check correct user input for answer
        if ((androidVer.equals("lollipop")) || (androidVer.equals("LOLLIPOP"))|| (androidVer.equals("Lollipop"))) {
           return true;
        }
        return false;
    }
    /**method to display final report
     *@param score
     *
     * */
    public void displayReport(int score){
        String msg = "Your Result is " ;
        msg += "\n " + score +" / 5";
        msg += "\n :)";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }
