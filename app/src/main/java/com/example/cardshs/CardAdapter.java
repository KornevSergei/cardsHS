package com.example.cardshs;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//описываем адаптер
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    //создаём лист из элементов и коснтурктор что бы можно обращаться
    ArrayList<CardItem> cardItems;

    //даём возможность клика по контексту в адаптере
    Context context;

    public CardAdapter(ArrayList<CardItem> cardItems, Context context) {
        this.cardItems = cardItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //присваиваем данный из хмл файла
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_description_item, parent, false);

        //создаём обьект класса который описывали ниже
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.CardViewHolder holder, int position) {
        //заполняем позициями
        CardItem cardItem = cardItems.get(position);

        holder.cardImageView.setImageResource(cardItem.getImageResource());
        holder.title.setText(cardItem.getTitle());
        holder.description.setText(cardItem.getDescription());


    }


    //возвращаем весь заполненный список
    @Override
    public int getItemCount() {
        return cardItems.size();
    }


    //обязательный класс для просмотра и имплиментриуем метод для клика по элементам
    public class CardViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        //поля из кмл
        public ImageView cardImageView;
        public TextView title;
        public TextView description;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            //связываем переменные с разметкой
            cardImageView = itemView.findViewById(R.id.cardImageView);
            title = itemView.findViewById(R.id.titleTextView);
            description = itemView.findViewById(R.id.descriptionTextView);
        }

        //описываем клик
        @Override
        public void onClick(View v) {
            //получаем позицию
            int position = getAdapterPosition();
            CardItem cardItem = cardItems.get(position);


            //делаем переход
            Intent intent = new Intent(context, FullDescriptionActivity.class);
            //связываем ключ и значение для определения позиции и вывода информации и передаем в интент
            intent.putExtra("imageResource",cardItem.getImageResource());
            intent.putExtra("title",cardItem.getTitle());
            intent.putExtra("description",cardItem.getDescription());
            intent.putExtra("fullDescription",cardItem.getFullDescription());
            context.startActivity(intent);
        }
    }

}
