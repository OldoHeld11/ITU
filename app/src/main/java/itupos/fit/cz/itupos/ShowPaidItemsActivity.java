package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class ShowPaidItemsActivity extends AppCompatActivity {

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

    public void refresh(){
        VariableSingleton.currentMyTable.ordersPaid.setTotalCostToBePaid(0);
        mTextMessage.setText(String.format(Locale.ENGLISH,"Total price: %d€", VariableSingleton.currentMyTable.ordersPaid.getTotalCost()));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_return:
                    intent = new Intent(context, SingleTableActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_paid_items);
        context = this;

        this.setTitle("Table " + VariableSingleton.currentMyTable.getTableNumber());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_paid_items);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // sum
        mTextMessage = (TextView) findViewById(R.id.appCompatTextView2);
        mTextMessage.setText(String.format(Locale.ENGLISH,"Total price: %d€", VariableSingleton.currentMyTable.ordersPaid.getTotalCost()));

        // recycle viewer
        mAdapter = new MyAdapterPaidItems(VariableSingleton.currentMyTable, this); //myadadpter
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2); //recycle_view v layout activite, pridat recycle_view s inym id
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        VariableSingleton.myInit();//ine
        mAdapter.notifyDataSetChanged();
    }

}
