package itupos.fit.cz.itupos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by martin on 4.12.2017.
 */

// pay out all orders
public class MyDialog2 extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.pay_selected_orders_question)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Orders orders = VariableSingleton.currentMyTable.orders;
                        Orders ordersPaid = VariableSingleton.currentMyTable.ordersPaid;

                        Order order;

                        List<Order> found = new ArrayList<Order>();

                        for(Order o : orders.getAllOrders()){
                            ordersPaid.setOrder(o.getName(), o.getToBePaid());

                            // order will be removed
                            if(Objects.equals(o.getAmount(), o.getToBePaid())) {
                                found.add(o);
                                orders.changeOrderAmount(o.getName(), -1);
                            }else{
                                orders.changeOrderAmount(o.getName(), o.getAmount() - o.getToBePaid());
                                o.setToBePaid(0);
                            }
                        }

                        orders.getAllOrders().removeAll(found);
                        if(orders.getAllOrders().isEmpty()){
                            VariableSingleton.currentMyTable.setFree(); // pridal Edo
                        }
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
