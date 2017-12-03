package itupos.fit.cz.itupos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import java.util.List;

/**
 * Created by martin on 3.12.2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private MyTable table;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.title);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(MyTable table) {
        this.table = table;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Orders orders = table.orders;
        holder.mTextView.setText(orders.getAllOrders().get(position).getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return table.orders.getOrdersCount();
    }
}
