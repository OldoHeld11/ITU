package itupos.fit.cz.itupos;

import java.util.ArrayList;

public class MyTable{
    private boolean isTaken;
    private int tableNumber;
    private int totalCost;

    public Orders orders;
    public Orders ordersPaid;

    public MyTable(int tableNumber) {
        this.isTaken = false;
        this.tableNumber = tableNumber;
        this.totalCost = 0;
        this.orders = new Orders();
        this.ordersPaid = new Orders();
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken() {
        isTaken = true;
    }
}
