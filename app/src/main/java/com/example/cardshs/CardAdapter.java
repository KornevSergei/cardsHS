package com.example.cardshs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//описываем адаптер
public class CardAdapter extends RecyclerView.Adapter <CardAdapter.CardViewHolder> {

    //создаём лист из элементов и коснтурктор что бы можно обращаться
    ArrayList<CardItem> cardItems;

    public CardAdapter(ArrayList<CardItem> cardItems) {
        this.cardItems = cardItems;
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


    //обязательный класс для просмотра
    public static class CardViewHolder extends RecyclerView.ViewHolder {

        //поля из кмл
        public ImageView cardImageView;
        public TextView title;
        public TextView description;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            //связываем переменные с разметкой
            cardImageView = itemView.findViewById(R.id.cardImageView);
            title = itemView.findViewById(R.id.titleTextView);
            description = itemView.findViewById(R.id.descriptionTextView);
        }
    }

}
