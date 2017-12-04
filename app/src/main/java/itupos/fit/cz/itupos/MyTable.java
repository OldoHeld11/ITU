package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyTable{
    private boolean isTaken;
    private int tableNumber;
    private ImageView tableView;

    public Orders orders;
    public Orders ordersPaid;

    public MyTable(int tableNumber) {
        this.isTaken = false;
        this.tableNumber = tableNumber;
        this.orders = new Orders();
        this.ordersPaid = new Orders();
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken() {
        isTaken = true;
        this.getTableView().setColorFilter(Color.argb(245, 255, 0, 0));
    }

    public void setFree(){
        isTaken = false;
        this.getTableView().setColorFilter(Color.argb(245, 0, 255, 0));
    }

    public int getTableNumber() {
        return tableNumber;
    }

    ///////////// Table view //////////////////////

    public ImageView getTableView() {
        return tableView;
    }

    public void setTableView(ImageView tableView, final Context context) {
        this.tableView = tableView;
        final MyTable thisTable = this;
        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariableSingleton.currentMyTable = thisTable;

                Intent intent = new Intent(context, SingleTableActivity.class);
                Toast.makeText(context, "Table "+ tableNumber, Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }

        });
    }
}
