package com.example.tonto.cooky;

/**
 * Created by tonto on 4/22/2017.
 */

public class RowItem {
    private String image;
    private String title;
    private String description;
    private String ingredients;
    private String recipe;

    public RowItem(String image, String title, String description, String ingredients, String recipe) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        return recipe;
    }
}
