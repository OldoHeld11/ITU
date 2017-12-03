package itupos.fit.cz.itupos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;



import java.util.HashMap;
import java.util.Map;

public class Table {
    private boolean isTaken;
    private int tableNumber;
    private ImageView tableView;
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

    public ImageView getTableView() {
        return tableView;
    }

    public void setTableView(ImageView tableView, final Context context) {
        this.tableView = tableView;
        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleTableActivity.class);
                Toast.makeText(context, "Table "+ tableNumber, Toast.LENGTH_LONG).show();
                VariableSingleton.selectedTableId = tableNumber;
                context.startActivity(intent);
            }

        });
    }
}
