package com.MyEnglish.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    // Список 2
    List<Word> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWords = findViewById(R.id.btn_words);
        Button buttonWork = findViewById(R.id.btn_work);
        Button buttonExit = findViewById(R.id.btn_exit);

        buttonExit.setOnClickListener(v -> finish());

        buttonWords.setOnClickListener(v -> {
            Toast.makeText(this, "Змінюємо кількість слів", Toast.LENGTH_SHORT).show();
        });

        buttonWork.setOnClickListener(v -> {
            // Список демонстраційних слів
            Word currentWord = new Word("нове", 5);
            insertIntoList2(list2, currentWord);

            // Показуємо результат (тільки для перевірки)
            StringBuilder result = new StringBuilder();
            for (Word w : list2) {
                result.append(w.getText()).append(" (").append(w.getCoefficient()).append(")\n");
            }

            Toast.makeText(this, "Список:\n" + result, Toast.LENGTH_LONG).show();
        });
    }

    // Алгоритм вставки у список 2
    public void insertIntoList2(List<Word> list2, Word currentWord) {
        boolean inserted = false;

        for (int i = 0; i < list2.size(); i++) {
            Word other = list2.get(i);
            if (currentWord.getCoefficient() >= other.getCoefficient()) {
                list2.add(i, currentWord);
                inserted = true;
                break;
            }
        }

        if (!inserted) {
            list2.add(0, currentWord); // вставити першим
        }
    }

    // Клас Word
    static class Word {
        private final String text;
        private final int coefficient;

        public Word(String text, int coefficient) {
            this.text = text;
            this.coefficient = coefficient;
        }

        public String getText() {
            return text;
        }

        public int getCoefficient() {
            return coefficient;
        }
    }
}
