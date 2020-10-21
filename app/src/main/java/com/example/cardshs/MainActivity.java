package com.example.cardshs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //обязательные переменные для обработки карт
    //видимость
    RecyclerView recyclerView;
    //адаптирование
    RecyclerView.Adapter adapter;
    //разметка
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //создаём список и наполняем элементами карт данными из конструктора
        ArrayList<CardItem> cardItemsList = new ArrayList();
        cardItemsList.add(new CardItem(R.drawable.card1, Utils.TITLE_1, Utils.DESCRIPTION_1, Utils.FULL_DESCRIPTION_1));
        cardItemsList.add(new CardItem(R.drawable.card2, Utils.TITLE_2, Utils.DESCRIPTION_2, Utils.FULL_DESCRIPTION_2));
        cardItemsList.add(new CardItem(R.drawable.card3, Utils.TITLE_3, Utils.DESCRIPTION_3, Utils.FULL_DESCRIPTION_3));
        cardItemsList.add(new CardItem(R.drawable.card4, Utils.TITLE_4, Utils.DESCRIPTION_4, Utils.FULL_DESCRIPTION_4));
        cardItemsList.add(new CardItem(R.drawable.card5, Utils.TITLE_5, Utils.DESCRIPTION_5, Utils.FULL_DESCRIPTION_5));
        cardItemsList.add(new CardItem(R.drawable.card6, Utils.TITLE_6, Utils.DESCRIPTION_6, Utils.FULL_DESCRIPTION_6));

        //связываем с основной активити
        recyclerView = findViewById(R.id.recyclerView);
        //передаем в адаптер лист из элементов
        recyclerView.setHasFixedSize(true);
        adapter = new CardAdapter(cardItemsList);
        //делаем разметку элементов
        layoutManager = new LinearLayoutManager(this);
        //устанавливаем одно в другое
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}