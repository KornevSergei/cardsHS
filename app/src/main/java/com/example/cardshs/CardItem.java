package com.example.cardshs;

//класс для описания карты
public class CardItem {

    //переменные для карты
    private int imageResource;
    private String title;
    private String description;
    private String fullDescription;


    public CardItem(int imageResource, String title, String description, String fullDescription) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.fullDescription = fullDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
