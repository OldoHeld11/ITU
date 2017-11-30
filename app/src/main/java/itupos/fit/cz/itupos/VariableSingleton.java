package itupos.fit.cz.itupos;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by oldo on 29.11.17.
 */

public class VariableSingleton {
    private static VariableSingleton instance;

    public static final String WAITER_1 = "0000";
    public static final String WAITER_2 = "1111";

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

}
