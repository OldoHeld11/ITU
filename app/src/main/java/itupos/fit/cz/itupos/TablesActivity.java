package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by oldo on 29.11.17.
 */

public class TablesActivity extends AppCompatActivity {

    private TextView Login_meno;
    private Context context;
    private Button btn_active;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        VariableSingleton.myInit();

        context = this;

        Login_meno = findViewById(R.id.tv_meno2);
        Login_meno.setText(VariableSingleton.Meno);
        VariableSingleton.tablesActivityContext = this;
        VariableSingleton.myTables[1].setTableView((ImageView) findViewById(R.id.table_1), context);
        VariableSingleton.myTables[2].setTableView((ImageView) findViewById(R.id.table_2), context);
        VariableSingleton.myTables[3].setTableView((ImageView) findViewById(R.id.table_3), context);
        VariableSingleton.myTables[4].setTableView((ImageView) findViewById(R.id.table_4), context);
        VariableSingleton.myTables[5].setTableView((ImageView) findViewById(R.id.table_5), context);
        VariableSingleton.myTables[6].setTableView((ImageView) findViewById(R.id.table_6), context);
        VariableSingleton.myTables[7].setTableView((ImageView) findViewById(R.id.table_7), context);
        VariableSingleton.myTables[8].setTableView((ImageView) findViewById(R.id.table_8), context);
        VariableSingleton.myTables[9].setTableView((ImageView) findViewById(R.id.table_9), context);
        VariableSingleton.myTables[10].setTableView((ImageView) findViewById(R.id.table_10), context);
        VariableSingleton.myTables[11].setTableView((ImageView) findViewById(R.id.table_11), context);
        VariableSingleton.myTables[12].setTableView((ImageView) findViewById(R.id.table_12), context);
        VariableSingleton.myTables[13].setTableView((ImageView) findViewById(R.id.table_13), context);

        for (int i = 1; i <= 13; i++) {
            VariableSingleton.myTables[i].setFree();
        }

       /* VariableSingleton.myTables[1].setTaken();
        VariableSingleton.myTables[2].setTaken();
        VariableSingleton.myTables[10].setTaken();
        VariableSingleton.myTables[5].setTaken();*/

        btn_active = (findViewById(R.id.btn_active_tables));

        btn_active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListActiveTablesActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(TablesActivity.this);
        alert.setTitle("Exit");
        alert.setMessage("Are you sure you want to exit?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alert.show();

    }
}
