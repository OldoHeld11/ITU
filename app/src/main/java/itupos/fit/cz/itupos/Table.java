package itupos.fit.cz.itupos;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

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
    private int roastChickenPrice = 320;
    private int totalCost;

    private Map<String,Integer> orders = new HashMap<String, Integer>();

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

    public void setTaken() {
        isTaken = true;
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

    public void OrderRoastChicken() {
        roastChickenOrders++;
        totalCost += roastChickenPrice;
    }

    public void OrderRoastChickens(int roastChickenOrders) {
        if(roastChickenOrders >= 1){
            this.roastChickenOrders = roastChickenOrders;
            totalCost += roastChickenOrders * roastChickenPrice;
        }
    }

    public void putOrder(String item){
        Integer ordersCount = orders.get(item);
        orders.put(item, ordersCount == null ? 1 : ordersCount + 1);
        totalCost += VariableSingleton.menuItemsPrices.get(item);
    }

    public void putOrder(String item, Integer count){
        if(count > 0){
            Integer ordersCount = orders.get(item);
            orders.put(item, ordersCount == null ? count : ordersCount + count);
            totalCost += VariableSingleton.menuItemsPrices.get(item) * count;
        }
    }

    public Integer getNumOfOrders(String item) {
        return (orders.get(item) == null) ? 0 : orders.get(item);
    }


    public void OrderBeer() {
        beerOrders++;
        totalCost += beerPrice;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
