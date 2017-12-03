package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by oldo on 29.11.17.
 */

public class TablesActivity extends AppCompatActivity {

    private ImageView table1Image;
    private  Context context;
    private Button btn_active;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        context = this;

        table1Image = findViewById(R.id.table_1);
        VariableSingleton.getTables()[2].setTableView((ImageView) findViewById(R.id.table_2),context);
        VariableSingleton.getTables()[3].setTableView((ImageView) findViewById(R.id.table_3),context);
        VariableSingleton.getTables()[4].setTableView((ImageView) findViewById(R.id.table_4),context);
        VariableSingleton.getTables()[5].setTableView((ImageView) findViewById(R.id.table_5),context);
        VariableSingleton.getTables()[6].setTableView((ImageView) findViewById(R.id.table_6),context);
        VariableSingleton.getTables()[7].setTableView((ImageView) findViewById(R.id.table_7),context);
        VariableSingleton.getTables()[8].setTableView((ImageView) findViewById(R.id.table_8),context);
        VariableSingleton.getTables()[9].setTableView((ImageView) findViewById(R.id.table_9),context);
        VariableSingleton.getTables()[10].setTableView((ImageView) findViewById(R.id.table_10),context);
        VariableSingleton.getTables()[11].setTableView((ImageView) findViewById(R.id.table_11),context);

        table1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleTableActivity.class);
                Toast.makeText(context, "Stol 1", Toast.LENGTH_LONG).show();
                VariableSingleton.selectedTableId = 1;
              //  VariableSingleton.selectedTableImage = table1Image;
                startActivity(intent);
            }

        });

        btn_active = (findViewById(R.id.btn_active_tables));

        btn_active.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ListActiveTablesActivity.class);
                startActivity(intent);
            }
        });




    }
}
