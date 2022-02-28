package com.example.tastethebest.ratings;

public class Rating {
    String id, recipeName, user, star, comment;

    public Rating() {

    }

    public Rating(String id, String recipeName, String user, String star, String comment) {
        this.id = id;
        this.recipeName = recipeName;
        this.user = user;
        this.star = star;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
