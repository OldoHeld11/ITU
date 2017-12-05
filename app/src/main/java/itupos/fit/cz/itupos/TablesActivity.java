package itupos.fit.cz.itupos;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by oldo on 29.11.17.
 */

public class TablesActivity extends android.support.v4.app.Fragment {

    private TextView Login_meno;
    private Context context;
    private Button btn_active;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_tables, null);
        return rootView;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        VariableSingleton.myInit();

        Activity activity = getActivity();
        context = activity;
        if (activity != null) {
            Login_meno = getView().findViewById(R.id.tv_meno2);
            Login_meno.setText(VariableSingleton.Meno);
        }
        VariableSingleton.tablesActivityContext = activity;
        VariableSingleton.myTables[1].setTableView((ImageView) activity.findViewById(R.id.table_1), context);
        VariableSingleton.myTables[2].setTableView((ImageView) activity.findViewById(R.id.table_2), context);
        VariableSingleton.myTables[3].setTableView((ImageView) activity.findViewById(R.id.table_3), context);
        VariableSingleton.myTables[4].setTableView((ImageView) activity.findViewById(R.id.table_4), context);
        VariableSingleton.myTables[5].setTableView((ImageView) activity.findViewById(R.id.table_5), context);
        VariableSingleton.myTables[6].setTableView((ImageView) activity.findViewById(R.id.table_6), context);
        VariableSingleton.myTables[7].setTableView((ImageView) activity.findViewById(R.id.table_7), context);
        VariableSingleton.myTables[8].setTableView((ImageView) activity.findViewById(R.id.table_8), context);
        VariableSingleton.myTables[9].setTableView((ImageView) activity.findViewById(R.id.table_9), context);
        VariableSingleton.myTables[10].setTableView((ImageView) activity.findViewById(R.id.table_10), context);
        VariableSingleton.myTables[11].setTableView((ImageView) activity.findViewById(R.id.table_11), context);
        VariableSingleton.myTables[12].setTableView((ImageView) activity.findViewById(R.id.table_12), context);
        VariableSingleton.myTables[13].setTableView((ImageView) activity.findViewById(R.id.table_13), context);

        for (int i = 1; i <= 13; i++) {
            VariableSingleton.myTables[i].setFree();
        }

       /* VariableSingleton.myTables[1].setTaken();
        VariableSingleton.myTables[2].setTaken();
        VariableSingleton.myTables[10].setTaken();
        VariableSingleton.myTables[5].setTaken();*/

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
/*
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

    }*/

