package pl.ds.schronisko.model;

public class Animal {
    public int id;
    public String name;
    public String description;
    public String imgUrl;
    public String category;



    public Animal() {
    }

    public Animal(int id, String name, String description, String imgUrl, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.category = category;
    }

    public Animal(String name, String description, String imgUrl, String category) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.category = category;
    }

    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategory() {
        return category;
    }

}
