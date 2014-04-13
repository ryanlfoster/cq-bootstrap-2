package ecommerce.domain;

public class Product {

    public String name;
    public String description;
    public String image;
    private double cost;
    private String code;

    public Product() {
    }

    public Product(String name, String description, String image, String code, double cost) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.code = code;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
