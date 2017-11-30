package itupos.fit.cz.itupos;

/**
 * Created by david on 30.11.17.
 */

public class Table {
    private boolean isTaken;
    private int tableNumber;
    private int waterOrders;
    private int beerOrders;
    private int roastChickenOrders;

    private int beerPrice = 35;
    private int totalCost;

    public Table(int TableNo) {
        this.isTaken = false;
        this.tableNumber = TableNo;
        this.waterOrders = 0;
        this.beerOrders = 0;
        this.roastChickenOrders = 0;
        this.totalCost = 0;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public int getBeerOrders() {
        return beerOrders;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void OrderBeers(int beerOrders) {
        if(beerOrders >= 1){
            this.beerOrders = beerOrders;
            totalCost += beerOrders * beerPrice;

        }
    }

    public void OrderBeer() {
        beerOrders++;
        totalCost += beerPrice;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
