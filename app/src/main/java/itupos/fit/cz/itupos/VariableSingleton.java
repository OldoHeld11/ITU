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
    public static Context tablesActivityContext;
    public static void myInit(){
        if(myTables != null){
            return;
        }


        myTables = new MyTable[15];
        for(int i = 1; i <= 13; i++){
            myTables[i] = new MyTable(i);

        }

        myMenu = new Menu();
        myMenu.setMenuItem("Bacon Burger", 8);
        myMenu.setMenuItem("Chilli Burger", 8);
        myMenu.setMenuItem("Pizza ala Sulo", 9);
        myMenu.setMenuItem("Madarsky gulas", 4);
        myMenu.setMenuItem("Piri piri chicken caesar ", 4);
        myMenu.setMenuItem("Sirlion Steak ", 12);
        myMenu.setMenuItem("Vodka", 4);
        myMenu.setMenuItem("Beef tartar", 7);
        myMenu.setMenuItem("Goat cheese", 5);
        myMenu.setMenuItem("Sprite", 4);
        myMenu.setMenuItem("Draught Beer", 2);
        myMenu.setDrinkIndex(5); //vymyslene
       /* myTables[1].orders.setOrder("burger", 2);
        myTables[1].orders.setOrder("pizza", 1);
        myTables[1].orders.removeOrder("pizza");
        myTables[1].orders.changeOrderAmount("burger", 1);
        myTables[1].orders.setOrder("pizza", 2);
        myTables[1].orders.setOrder("pizza2", 2);
        myTables[1].orders.setOrder("pizza3", 2);
        myTables[1].orders.setOrder("pizza4", 2);
        myTables[1].orders.setOrder("burger2", 2);
        myTables[1].orders.setOrder("burger3", 2);
        myTables[1].orders.setOrder("burger4", 2);
        myTables[1].orders.setOrder("1burger", 2);
        myTables[1].orders.setOrder("2burger", 2);
        myTables[1].orders.setOrder("3burger", 2);
        myTables[1].orders.setOrder("4burger", 2);
        myTables[1].orders.setOrder("5burger", 2);
        myTables[1].orders.setOrder("6burger", 2);
        myTables[1].orders.setOrder("7burger", 2);
        myTables[1].orders.setOrder("8burger", 2);
        myTables[1].orders.setOrder("9burger", 2);*/

    }
/////////////////////////////////////////////////////////////////////////////////

    private static VariableSingleton instance;

    public static final String WAITER_1 = "0000";
    public static final String WAITER_2 = "1111";
    public static  String Meno ;


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

}
