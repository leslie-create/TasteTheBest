package com.example.tastethebest.ratings;

public class Recipe {
    String id, category, name, ingredients, procedure, user;

    public Recipe() {

    }

    public Recipe(String id, String category, String name, String ingredients, String procedure, String user) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.ingredients = ingredients;
        this.procedure = procedure;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
