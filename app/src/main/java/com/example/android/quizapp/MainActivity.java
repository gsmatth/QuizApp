package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String[] correctAnswerText = {
      "variable", "String", "int"
    };

    int quantityOfCorrectAnswers = 0;


    public void scoreQuiz(View view){
        EditText textAnswerObject = (EditText) findViewById(R.id.question_1_answer);
        String textAnswerString = textAnswerObject.getText().toString();

        if(textAnswerString.equals(correctAnswerText[0])){
            quantityOfCorrectAnswers += 1;
            Log.i("mainActivity", "value of correctAnswers: " + quantityOfCorrectAnswers);
        }

    }


}
