package dev.ogabek.exam4th.model;

public class Food {

    int img;
    String name;
    double price;
    float score;
    String restaurant;
    String location;

    public Food(int img, String name, double price, float score, String restaurant, String location) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.score = score;
        this.restaurant = restaurant;
        this.location = location;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public float getScore() {
        return score;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getLocation() {
        return location;
    }
}
