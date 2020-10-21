package com.example.cardshs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FullDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description);

        //связываем поля нового ативити
        TextView title = findViewById(R.id.titleTextView);
        TextView fullDescription = findViewById(R.id.fullDescriptionTextView);


        //извлекаем информацию
        Intent intent = getIntent();
        if (intent != null){
            //получая информацию устанавливаем тексты по ключу из адаптера
            title.setText(intent.getStringExtra("title"));
            fullDescription.setText(intent.getStringExtra("fullDescription"));

        }


    }
}