package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

/**
 * Created by martin on 3.12.2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private MyTable table; //zmenit na vlastnu
    private MyViewHolder holder;
    private TextView sum;
    private SingleTablePayOutActivity payOutActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView toBePaidView;
        public Button buttonPlus;
        public Button buttonMinus;
        public TextView sum;
        public MyViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.title);
            buttonMinus = (Button) itemView.findViewById(R.id.decrease);
            buttonPlus = (Button) itemView.findViewById(R.id.increase);
            toBePaidView = (TextView) itemView.findViewById(R.id.integer_number);
            sum = (TextView) itemView.findViewById(R.id.appCompatTextView);
        }
    }

    public void refresh(Order order, Integer orderChange){
        table.orders.setTotalCostToBePaid(table.orders.getTotalCostToBePaid() + orderChange * VariableSingleton.myMenu.getMenuItem(order.getName()).getPrice());
        payOutActivity.getmTextMessage().setText(String.format(Locale.ENGLISH,"Price: %d/%d$", table.orders.getTotalCostToBePaid(), table.orders.getTotalCost()));
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(MyTable table, SingleTablePayOutActivity payOutActivity) {
        this.table = table;
        this.payOutActivity = payOutActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        final View itemView = inflater.inflate(R.layout.my_text_view, parent, false); //zmenit my_text_view, je to layout, zmenit idcka

        return new MyViewHolder(itemView);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        this.holder = holder;
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Orders orders = table.orders;
        Orders ordersPaid = table.ordersPaid;
        final Order order = orders.getAllOrders().get(position);

        holder.mTextView.setText(order.getName()); // sem dat text ktory sa zobrazi v my-text_view

        holder.toBePaidView.setText(String.format(Locale.ENGLISH,"%d/%d", order.getToBePaid(), order.getAmount()));

        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(order.getAmount() > order.getToBePaid()){
                    order.setToBePaid(order.getToBePaid() + 1);
                    notifyDataSetChanged();
                    refresh(order, 1);
                }
            }
        });

        holder.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(0 < order.getToBePaid()){
                    order.setToBePaid(order.getToBePaid() - 1);
                    notifyDataSetChanged();
                    refresh(order, -1);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.setToBePaid(order.getAmount());
                notifyDataSetChanged();
                refresh(order, order.getAmount());
            }
        });


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
        return table.orders.getOrdersCount();
    } // pocet poloziek


}
