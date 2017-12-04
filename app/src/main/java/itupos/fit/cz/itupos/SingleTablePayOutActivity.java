package itupos.fit.cz.itupos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SingleTablePayOutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    public RecyclerView.Adapter getmAdapter() {
        return mAdapter;
    }

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TextView getmTextMessage() {
        return mTextMessage;
    }

    private TextView mTextMessage;
    private Context context;

    DialogFragment newFragment;
    DialogFragment newFragment2;

    public void confirmFireMissiles() {
        newFragment.show(getFragmentManager(), "missiles");
    }

    public void confirmFireMissiles2() {
        newFragment2.show(getFragmentManager(), "missiles2");
    }

    public void refresh(){
        VariableSingleton.currentMyTable.orders.setTotalCostToBePaid(0);
        mTextMessage.setText(String.format(Locale.ENGLISH,"Price: %d/%d€", VariableSingleton.currentMyTable.orders.getTotalCostToBePaid(), VariableSingleton.currentMyTable.orders.getTotalCost()));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_pay_all:
                    confirmFireMissiles();
                    mAdapter.notifyDataSetChanged();
                    return true;

                case R.id.navigation_pay_selected:
                    confirmFireMissiles2();
                    mAdapter.notifyDataSetChanged();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_table_pay_out);
        context = this;
        this.setTitle("Table " + VariableSingleton.currentMyTable.getTableNumber());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_pay_out);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // sum
        mTextMessage = (TextView) findViewById(R.id.appCompatTextView);
        mTextMessage.setText(String.format(Locale.ENGLISH,"Price: %d/%d$", VariableSingleton.currentMyTable.orders.getTotalCostToBePaid(), VariableSingleton.currentMyTable.orders.getTotalCost()));

        // recycle viewer
        mAdapter = new MyAdapter(VariableSingleton.currentMyTable, this); //myadadpter
        newFragment = new MyDialog();
        newFragment2 = new MyDialog2();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view); //recycle_view v layout activite, pridat recycle_view s inym id
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        VariableSingleton.myInit();//ine
        mAdapter.notifyDataSetChanged();
    }
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, SingleTableActivity.class);
        startActivity(intent);
    }


}
