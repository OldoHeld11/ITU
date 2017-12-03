package itupos.fit.cz.itupos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by martin on 3.12.2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Table table;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Table table) {
        this.table = table;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_single_table_pay_out, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        int count = 0;
        int positionInMap = 0;
        for(int i = 0; i < VariableSingleton.menuItems.size(); i++){
            if(VariableSingleton.currentTable.getNumOfOrders(VariableSingleton.menuItems.get(i)) > 0){
                count++;
            }
            if(count == position) {
                positionInMap = i;
                break;
            }
        }
        //holder.mTextView.setText(VariableSingleton.menuItems.get(VariableSingleton.currentTable.getNumOfOrders(positionInMap)));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        int count = 0;
        for(int i = 0; i < VariableSingleton.menuItems.size(); i++){
            if(VariableSingleton.currentTable.getNumOfOrders(VariableSingleton.menuItems.get(i)) > 0){
                count++;
            }
        }
        return count;
    }
}
