package itupos.fit.cz.itupos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListActiveTablesActivity extends android.support.v4.app.Fragment {
    private Context context;
    private TextView Login_meno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_list_active_tables, null);

        // Create UI components here.
        Activity activity = getActivity();
        //setContentView(R.layout.activity_list_active_tables);
        context = activity;

        activity.setTitle("All Active Tables");


        Login_meno = view.findViewById(R.id.tv_meno);
        Login_meno.setText(VariableSingleton.Meno);

        //test creating of dynamic buttons
        //  Button[] myButton = new Button[14];

        //view = inflater.inflate(R.layout.activity_list_active_tables, scrViewButLay);
        return view;
    }

    public void onStart() {

        super.onStart();

        LinearLayout[] rows = new LinearLayout[7];
        LinearLayout scrViewButLay = getActivity().findViewById(R.id.rl_table_of_contents);
        scrViewButLay.removeAllViewsInLayout();
        scrViewButLay.setOrientation(LinearLayout.VERTICAL);

        int activeTables = 0;

        for(int index = 1; index <= 13; index++){

            if(VariableSingleton.myTables[index].isTaken()) {
                // rows[index] = new LinearLayout(this);
                // rows[index].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                //  myButton[index] = new Button(this);//initialize the button here
                // myButton[index].setText("Table " + index);
                if(activeTables % 3 == 0){
                    rows[activeTables/3] = new LinearLayout(getActivity());
                    rows[activeTables/3].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                }
                activeTables++;
                //LinearLayout row = new LinearLayout(this);
                //row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                Button btnTable = new Button(getActivity());
                btnTable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                btnTable.setText("Table " + index);


                final int finalI = index;

                btnTable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, SingleTableActivity.class);
                        Toast.makeText(context, "Table " + finalI, Toast.LENGTH_LONG).show();
                        VariableSingleton.currentMyTable = VariableSingleton.myTables[finalI];
                        startActivity(intent);
                    }
                });

                rows[(activeTables - 1)/3].addView(btnTable);
                //row.addView(btnTable);
                //scrViewButLay.addView(row);
                if(( (activeTables - 1) % 3) == 0)
                    scrViewButLay.addView(rows[activeTables/3]);

            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    public void onResume() {

        super.onResume();

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}







