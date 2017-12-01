package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class ListActiveTablesActivity extends AppCompatActivity {
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_active_tables);
        context = this;
        VariableSingleton.getTables()[1].setTaken();
        VariableSingleton.getTables()[3].setTaken();
        VariableSingleton.getTables()[5].setTaken();


            //test creating of dynamic buttons
            Button[] myButton = new Button[16];
            LinearLayout scrViewButLay = (LinearLayout) findViewById(R.id.rl_table_of_contents);
            for(int index = 0; index < 15; index++) {

                if(VariableSingleton.getTables()[index].isTaken()) {
                    myButton[index] = new Button(this);//initialize the button here
                    myButton[index].setText("Table " + index);
                    final int finalI = index;

                    myButton[index].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, SingleTableActivity.class);
                            Toast.makeText(context, "Stol "+finalI, Toast.LENGTH_LONG).show();
                            VariableSingleton.selectedTableId = finalI;
                            startActivity(intent);
                        }
                    });

                    scrViewButLay.addView(myButton[index]);
                }
            }
            }
        }







