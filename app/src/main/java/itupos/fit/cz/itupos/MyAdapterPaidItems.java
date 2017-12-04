package itupos.fit.cz.itupos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by martin on 3.12.2017.
 */

class MyAdapterPaidItems extends RecyclerView.Adapter<MyAdapterPaidItems.MyViewHolder> {
    private MyTable table; //zmenit na vlastnu
    private MyViewHolder holder;
    private TextView sum;
    private ShowPaidItemsActivity payOutActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView toBePaidView;
        public Button btnReturn;
        public TextView sum;
        public MyViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.title_paid);
            btnReturn = (Button) itemView.findViewById(R.id.navigation_return);
            toBePaidView = (TextView) itemView.findViewById(R.id.number_paid);
            sum = (TextView) itemView.findViewById(R.id.appCompatTextView2);
        }
    }

    public void refresh(Order order, Integer orderChange){
        table.ordersPaid.setTotalCostToBePaid(table.ordersPaid.getTotalCostToBePaid() + orderChange * VariableSingleton.myMenu.getMenuItem(order.getName()).getPrice());
        payOutActivity.getmTextMessage().setText(String.format(Locale.ENGLISH,"Total price: %d", table.ordersPaid.getTotalCost()));
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterPaidItems(MyTable table, ShowPaidItemsActivity payOutActivity) {
        this.table = table;
        this.payOutActivity = payOutActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        final View itemView = inflater.inflate(R.layout.my_text_view_paid_items, parent, false); //zmenit my_text_view, je to layout, zmenit idcka

        return new MyViewHolder(itemView);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        this.holder = holder;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Orders orders = table.ordersPaid;
        final Order order = orders.getAllOrders().get(position);

        holder.mTextView.setText(order.getName()); // sem dat text ktory sa zobrazi v my-text_view

        holder.toBePaidView.setText(String.format(Locale.ENGLISH,"%d", order.getAmount()));

/*
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(false);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });*/
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return table.ordersPaid.getOrdersCount();
    } // pocet poloziek


}
