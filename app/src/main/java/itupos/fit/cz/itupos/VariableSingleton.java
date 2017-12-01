package itupos.fit.cz.itupos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VariableSingleton {
    private static VariableSingleton instance;

    public static final String WAITER_1 = "0000";
    public static final String WAITER_2 = "1111";
    public static int selectedTableId;
    public static ImageView selectedTableImage;
    private static Table[] tables;
    public static Map<Integer,String> menuItems = new HashMap<Integer, String>();
    public static Map<String,Integer> menuItemsPrices = new HashMap<String, Integer>();

    private VariableSingleton(){}

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
