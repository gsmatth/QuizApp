package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String[] correctAnswerText = {
            "int", "boolean", "String"
    };

    int quantityOfCorrectAnswers = 0;


    public void scoreQuiz(View view) {
        scoreTextQuestions(view);
        scoreCheckboxQuestions(view);

        float quizScoreInPercent = (quantityOfCorrectAnswers / 8.00f) * 100;

        if (quizScoreInPercent >= 75) {
            Toast.makeText(this, "You have passed the quiz, with a score of " + quizScoreInPercent + "%", Toast.LENGTH_SHORT).show();
            quantityOfCorrectAnswers = 0;
            return;

        } else {
            Toast.makeText(this, "You have not passed the quiz, your score is " + quizScoreInPercent + "%", Toast.LENGTH_SHORT).show();
            quantityOfCorrectAnswers = 0;
            return;
        }
    }

    private void scoreTextQuestions(View view) {
        EditText textAnswerObject = (EditText) findViewById(R.id.question_1_answer);
        String textAnswerString = textAnswerObject.getText().toString();
        if (textAnswerString.equals(correctAnswerText[0])) {
            quantityOfCorrectAnswers += 1;
            Log.i("mainActivity", "value of correctAnswers: " + quantityOfCorrectAnswers);
        }

        EditText textAnswerTwoObject = (EditText) findViewById(R.id.question_2_answer);
        String textAnswerTwoString = textAnswerTwoObject.getText().toString();
        if (textAnswerTwoString.equals(correctAnswerText[1])) {
            quantityOfCorrectAnswers += 1;
            Log.i("mainActivity", "value of correctAnswers: " + quantityOfCorrectAnswers);
        }
        EditText textAnswerThreeObject = (EditText) findViewById(R.id.question_3_answer);
        String textAnswerThreeString = textAnswerThreeObject.getText().toString();
        if (textAnswerThreeString.equals(correctAnswerText[2])) {
            quantityOfCorrectAnswers += 1;
            Log.i("mainActivity", "value of correctAnswers: " + quantityOfCorrectAnswers);
        }

    }

    private void scoreCheckboxQuestions(View view){
        boolean hasClass = ((CheckBox) findViewById(R.id.question_4_box_one)).isChecked();
        if(hasClass){
            quantityOfCorrectAnswers += 1;
        }

    }
}