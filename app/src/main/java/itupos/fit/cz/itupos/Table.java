package itupos.fit.cz.itupos;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private boolean isTaken;
    private int tableNumber;

    private int totalCost;

    private Map<String,Integer> orders = new HashMap<String, Integer>();
    private Map<String,Integer> paidItems = new HashMap<String, Integer>();

    public Table(int TableNo) {
        this.isTaken = false;
        this.tableNumber = TableNo;
        this.totalCost = 0;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken() {
        isTaken = true;
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


    public Integer getNumOfPaidItems(String item) {
        return (paidItems.get(item) == null) ? 0 : paidItems.get(item);
    }


    /*
    * "Zaplatia" sa vsetky polozky daneho itemu, ak nejake vobec su.
    * Navratova hodnota je pocet kolko sa vyplatilo alebo null ak takato polozka nebola objednana.
    * Znizi sa aj celkovy ucet stolu
    * **/
    public Integer hasBeenPaid(String item){
        Integer removedCount = orders.remove(item);
        if(removedCount == null) return null;
        totalCost -= ( removedCount * VariableSingleton.menuItemsPrices.get(item) ) ;
        return removedCount;
    }

    /*
    * "Zaplati" sa [count] poloziek daneho itemu.
    * Znizi sa aj celkovy ucet stolu.
    **/
    public void hasBeenPaid(String item, Integer count){
        Integer ordersCount = orders.get(item);
        if(ordersCount == null) return;
        if(ordersCount <= count){
            hasBeenPaid(item);
        } else {
            orders.put(item, ordersCount - count);
            totalCost -= VariableSingleton.menuItemsPrices.get(item) * count;
        }
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
