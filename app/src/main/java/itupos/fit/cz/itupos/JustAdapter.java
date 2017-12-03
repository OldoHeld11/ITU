package itupos.fit.cz.itupos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by oldo on 3.12.17.
 */

public class JustAdapter extends RecyclerView.Adapter<JustAdapter.JustViewHolder>  {
    private Context context;
    private Menu menu; //zmenit na vlastnu

    public class JustViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public JustViewHolder(View v) {
            super(v);
            mTextView = (TextView) itemView.findViewById(R.id.justTitle);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public JustAdapter(Menu menu) {
        this.menu = menu;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public JustAdapter.JustViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.just_text_view, parent, false); //zmenit my_text_view, je to layout, zmenit idcka

        return new JustAdapter.JustViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(JustAdapter.JustViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(menu.getAllMenuItems().get(position).getName()); // sem dat text ktory sa zobrazi v my-text_view

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               VariableSingleton.currentMyTable.orders.setOrder(menu.getAllMenuItems().get(position).getName(),1);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return menu.getMenuCount();
    } // pocet poloziek

}
