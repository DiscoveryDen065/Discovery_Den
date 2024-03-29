package com.example.hackathon2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.checkerframework.common.subtyping.qual.Bottom;

public class storyquiz extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionTextView;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submit;

    int score=0;
    int totalQuestion = QuestionAnswer1.question.length;
    int currentQuestionIndex =0;
    String selectedAnswer = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storyquiz);

        totalQuestionTextView = findViewById(R.id.totalques);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ansA);
        ansB = findViewById(R.id.ansB);
        ansC = findViewById(R.id.ansC);
        ansD = findViewById(R.id.ansD);
        submit = findViewById(R.id.submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        totalQuestionTextView.setText("Tota questions : "+totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit){
            if(selectedAnswer.equals(QuestionAnswer1.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestion(){
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer1.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer1.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer1.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer1.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer1.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus="Passed";
        }
        else {
            passStatus="Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz())
//                .setCancelable(false)
                .show();
    }
    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }
}