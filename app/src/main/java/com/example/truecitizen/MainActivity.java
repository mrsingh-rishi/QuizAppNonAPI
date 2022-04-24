package com.example.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.truecitizen.databinding.ActivityMainBinding;
import com.example.truecitizen.model.Question;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;



    private Question[] questionBank = new Question[]{
            new Question(R.string.question_amendments, false), //correct: 27
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true),
    };
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.questionTextView.setText(questionBank[i].getAnsResId());
    }

    public void prev(View view) {
        if(i>1){
            i = (i-1) % questionBank.length;
            updateQuestion();
        }
    }

    private void updateQuestion() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.questionTextView.setText(questionBank[i].getAnsResId());
    }

    public void next(View view) {

            i = (i+1) % questionBank.length;
            updateQuestion();

    }

    public void checkFalse(View view) {
        if(questionBank[i].isAnswerTrue() == false){
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Ooh hoo Wrong Answer", Toast.LENGTH_SHORT).show();
        }
        next();
    }

    private void next() {
        i = (i+1) % questionBank.length;
        updateQuestion();
    }

    public void checkTrue(View view) {
        if(questionBank[i].isAnswerTrue() == true){
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Ooh hoo Wrong Answer", Toast.LENGTH_SHORT).show();
        }
        next();
    }
}