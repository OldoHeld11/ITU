package itupos.fit.cz.itupos;

public class Order{

    public Order(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
        this.totalPrice = VariableSingleton.myMenu.getMenuItemPrice(this.getName()) * amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
        this.setTotalPrice(VariableSingleton.myMenu.getMenuItemPrice(this.getName()) * amount);
    }

    private String name;
    private Integer totalPrice;
    private Integer amount;
}
