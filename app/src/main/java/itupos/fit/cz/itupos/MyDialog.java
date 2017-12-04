package itupos.fit.cz.itupos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by martin on 4.12.2017.
 */

// pay out all orders
public class MyDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.pay_all_orders_question)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Orders orders = VariableSingleton.currentMyTable.orders;
                        Orders ordersPaid = VariableSingleton.currentMyTable.ordersPaid;

                        Order order;

                        List<Order> found = new ArrayList<Order>();

                        for(Order o : orders.getAllOrders()){
                            found.add(o);
                            ordersPaid.setOrder(o.getName(), o.getAmount());
                            // it will not be deleted now but prepared for deletion
                            orders.changeOrderAmount(o.getName(), -1);
                        }

                        orders.getAllOrders().removeAll(found);
                        VariableSingleton.currentMyTable.setFree(); // pridal Edo
                        VariableSingleton.currentMyTable.ordersPaid.getAllOrders().clear();
                        VariableSingleton.currentMyTable.ordersPaid.setTotalCost(0);
                        RecyclerView.Adapter myAdapter = ((SingleTablePayOutActivity)getActivity()).getmAdapter();
                        myAdapter.notifyDataSetChanged();
                        ((SingleTablePayOutActivity)getActivity()).refresh();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
