package itupos.fit.cz.itupos;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VariableSingleton {

    // ide to aj lepsie //////////////////////////////////////////////////////////
    public static Menu myMenu;
    public static MyTable[] myTables;
    public static MyTable currentMyTable;
    public static String aha[] = {"aha1", "aha2"};

    public static void myInit(){
        myMenu = new Menu();
        myMenu.setMenuItem("burger", 50);
        myMenu.setMenuItem("pizza", 40);
        myTables = new MyTable[15];
        myTables[0] = new MyTable(1);
        currentMyTable = myTables[0];
        myTables[0].orders.setOrder("burger", 2);
        myTables[0].orders.setOrder("pizza", 1);
        myTables[0].orders.removeOrder("pizza");
        myTables[0].orders.changeOrderAmount("burger", 1);
    }
/////////////////////////////////////////////////////////////////////////////////

    private static VariableSingleton instance;

    public static final String WAITER_1 = "0000";
    public static final String WAITER_2 = "1111";
    public static  String Meno ;
    public static int selectedTableId;
    public static ImageView selectedTableImage;
    private static Table[] tables;
    public static Map<Integer,String> menuItems = new HashMap<Integer, String>();
    public static Map<String,Integer> menuItemsPrices = new HashMap<String, Integer>();
    public static Table currentTable;

    private VariableSingleton(){}
    public static void setName(String meno){
        Meno=meno;
    }

    public static VariableSingleton getInstance() {
        if (instance == null) {
            return new VariableSingleton();
        } else {
            return  instance;
        }
    }

    public void createToast(Context context) {
        Toast.makeText(context, "Singleton", Toast.LENGTH_LONG).show();
    }

    public static Table[] InitializeTables(){
        tables = new Table[15];
        for(int i = 0; i < tables.length; i++){
            tables[i] = new Table(i);
        }

        /* pridavam aj inicializaciu menu poloziek **/
        menuItems.put(0, "Water");
        menuItems.put(1, "Beer");
        menuItems.put(2, "Chicken");
        menuItems.put(3, "Pizza");
        menuItems.put(4, "Pasta");
        menuItemsPrices.put("Water", 25);
        menuItemsPrices.put("Beer", 35);
        menuItemsPrices.put("Chicken", 250);
        menuItemsPrices.put("Pizza", 190);
        menuItemsPrices.put("Pasta", 225);
        /* **/

        return tables;
    }


    public static Table[] getTables() {
        return tables;
    }
}
