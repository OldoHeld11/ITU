package itupos.fit.cz.itupos;

public class Order{
    private String name;
    private Integer totalPrice;
    private Integer amount;

    public Integer getToBePaid() {
        return toBePaid;
    }

    public void setToBePaid(Integer toBePaid) {
        this.toBePaid = toBePaid;
    }

    private Integer toBePaid;

    public Order(String name, Integer amount) {
        if(VariableSingleton.myMenu.getMenuItem(name) != null) {
            this.name = name;
            this.amount = amount;
            this.totalPrice = VariableSingleton.myMenu.getMenuItemPrice(this.getName()) * amount;
            this.toBePaid = 0;
        }
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
}
