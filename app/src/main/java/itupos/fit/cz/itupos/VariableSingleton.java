package itupos.fit.cz.itupos;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

public class VariableSingleton {
    private static VariableSingleton instance;

    public static final String WAITER_1 = "0000";
    public static final String WAITER_2 = "1111";
    public static int selectedTableId;
    public static ImageView selectedTableImage;
    private static Table[] tables;


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
        return tables;
    }

    public static Table[] getTables() {
        return tables;
    }
}
