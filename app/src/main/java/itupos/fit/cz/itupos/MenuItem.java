package itupos.fit.cz.itupos;

/**
 * Created by david on 30.11.17.
 */

public class MenuItem {
    private String name;
    private Integer price;

    public MenuItem(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
