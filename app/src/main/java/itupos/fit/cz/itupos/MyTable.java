package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyTable{
    private boolean isTaken;
    private int tableNumber;

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
    }

    public int getTableNumber() {
        return tableNumber;
    }

    ///////////// Table view //////////////////////

    private ImageView tableView;

    public ImageView getTableView() {
        return tableView;
    }

    public void setTableView(ImageView tableView, final Context context) {
        this.tableView = tableView;
        tableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleTableActivity.class);
                Toast.makeText(context, "Table "+ tableNumber, Toast.LENGTH_LONG).show();
                VariableSingleton.selectedTableId = tableNumber;
                context.startActivity(intent);
            }

        });
    }
}
