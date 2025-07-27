package com.MyEnglish.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseWordsCountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_words_count);

        Button button100 = findViewById(R.id.button100);
        Button button200 = findViewById(R.id.button200);
        Button buttonExit = findViewById(R.id.buttonExit2);

        button100.setOnClickListener(v -> {
            Intent intent = new Intent(this, WorkWithWordsActivity.class);
            intent.putExtra("wordsCount", 100);
            startActivity(intent);
        });

        button200.setOnClickListener(v -> {
            Intent intent = new Intent(this, WorkWithWordsActivity.class);
            intent.putExtra("wordsCount", 200);
            startActivity(intent);
        });

        buttonExit.setOnClickListener(v -> finish());
    }
}
