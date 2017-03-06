package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.checked;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.android.quizapp.R.id.question_4_box_one;
import static com.example.android.quizapp.R.id.question_4_box_three;
import static com.example.android.quizapp.R.id.question_4_box_two;
import static com.example.android.quizapp.R.id.question_5_box_one;
import static com.example.android.quizapp.R.id.question_5_box_three;
import static com.example.android.quizapp.R.id.question_5_box_two;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantityOfCorrectAnswers = 0;

    /**
     * Responsible for scoring the quiz and displaying results once the SUBMIT button is pressed.
     * Invokes methods to scoreTextQuestions, scoreCheckboxQuestions, and scoreRadioButtonQuesitons.
     * Also displays the results by instantiating a Toast
     * @param view takes a View object used by other invoked methods to access user input
     *
     * @since   2017-03-02
     */
    public void scoreQuiz(View view) {
        scoreTextQuestions();
        scoreCheckboxQuestions();
        scoreRadioButtonQuestions();

        float quizScoreInPercent = (quantityOfCorrectAnswers / 6.00f) * 100;

        if (quizScoreInPercent >= 75) {
            Toast.makeText(this, "You have passed the quiz, with a score of " + quizScoreInPercent + "%",
                    Toast.LENGTH_SHORT).show();
            quantityOfCorrectAnswers = 0;
        } else {
            Toast.makeText(this, "You have not passed the quiz, your score is " + quizScoreInPercent + "%",
                    Toast.LENGTH_SHORT).show();
            quantityOfCorrectAnswers = 0;
        }
    }

    /**
     * Scores the quiz questions that require answers be added into EditText views
     * Accesses each questions EditText View, stringifies contents, and compares the
     * content against the array of correct answers.
     * @since   2017-03-02
     */
    private void scoreTextQuestions() {
        String[] correctAnswerText = {
                "int", "boolean", "String"
        };

        int [] ids = {
                R.id.question_1_answer,
                R.id.question_2_answer,
                R.id.question_3_answer
        };

        for(int i = 0; i < ids.length; i++){
            checkAnswer(ids[i], correctAnswerText[i]);
        }
    }

    private void checkAnswer(int id, String expectedAnswer){
        EditText textAnswerObject = (EditText) findViewById(id);
        String textAnswerString = textAnswerObject.getText().toString();
        if (textAnswerString.equals(expectedAnswer)) {
            quantityOfCorrectAnswers += 1;
        }
    }

    /**
     * Scores the quiz questions that require checkbox answers
     * Accesses each questions CheckBox View, assigns boolean value of
     * current state, and compares states to determine if question is answered correctly
     * @since   2017-03-02
     */
    private void scoreCheckboxQuestions() {
        boolean hasClass = ((CheckBox) findViewById(question_4_box_one)).isChecked();
        boolean hasInt = ((CheckBox) findViewById(question_4_box_two)).isChecked();
        boolean hasArray = ((CheckBox) findViewById(question_4_box_three)).isChecked();
        if (hasInt && !hasClass && !hasArray) {
            quantityOfCorrectAnswers += 1;
        }

        boolean hasIfThen = ((CheckBox) findViewById(question_5_box_one)).isChecked();
        boolean hasWhile = ((CheckBox) findViewById(question_5_box_two)).isChecked();
        boolean hasWhileElse = ((CheckBox) findViewById(question_5_box_three)).isChecked();
        if (hasIfThen && hasWhile && !hasWhileElse) {
            quantityOfCorrectAnswers += 1;
        }

    }

    /**
     * Scores the quiz questions that require RadioButton answers
     * Accesses the correct answers RadioButton View, assigns boolean value of
     * current state, and compares states to determine if question is answered correctly
     * @since   2017-03-02
     */
    private void scoreRadioButtonQuestions() {
        boolean hasNumber = ((RadioButton) findViewById(R.id.question_6_radio_button_one)).isChecked();

        if (hasNumber) quantityOfCorrectAnswers += 1;
    }

    /**
     * Resets all answers to empty/false when RESET button is pushed/clicked.
     * Accesses all EditText views and resets to empty string.  Sets all CheckBox
     * and RadioButtons to false.
     * @since   2017-03-02
     */
    public void resetQuiz(View view) {

        EditText textAnswerOne = (EditText) findViewById(R.id.question_1_answer);
        textAnswerOne.setText("");
        EditText textAnswerTwo = (EditText) findViewById(R.id.question_2_answer);
        textAnswerTwo.setText("");
        EditText textAnswerThree = (EditText) findViewById(R.id.question_3_answer);
        textAnswerThree.setText("");

        CheckBox questionFourBoxOne = (CheckBox) findViewById(question_4_box_one);
        questionFourBoxOne.setChecked(false);
        CheckBox questionFourBoxTwo = (CheckBox) findViewById(question_4_box_two);
        questionFourBoxTwo.setChecked(false);
        CheckBox questionFourBoxThree = (CheckBox) findViewById(question_4_box_three);
        questionFourBoxThree.setChecked(false);

        CheckBox questionFiveBoxOne = (CheckBox) findViewById(question_5_box_one);
        questionFiveBoxOne.setChecked(false);
        CheckBox questionFiveBoxTwo = (CheckBox) findViewById(question_5_box_two);
        questionFiveBoxTwo.setChecked(false);
        CheckBox questionFiveBoxThree = (CheckBox) findViewById(question_5_box_three);
        questionFiveBoxThree.setChecked(false);

        RadioButton buttonOne = (RadioButton) findViewById(R.id.question_6_radio_button_one);
        buttonOne.setChecked(false);
        RadioButton buttonTwo = (RadioButton) findViewById(R.id.question_6_radio_button_two);
        buttonTwo.setChecked(false);
        RadioButton buttonThree = (RadioButton) findViewById(R.id.question_6_radio_button_three);
        buttonThree.setChecked(false);


    }
}