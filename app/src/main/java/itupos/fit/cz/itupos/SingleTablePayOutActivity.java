package itupos.fit.cz.itupos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SingleTablePayOutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView mTextMessage;
    private Context context;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_pay_all:
                    //mTextMessage.setText(R.string.title_add);
                    return true;
                /*case R.id.navigation_order:
                    mTextMessage.setText(R.string.title_add);
                    return true;*/
                case R.id.navigation_pay_selected:
                    //mTextMessage.setText(R.string.title_add);
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

        this.setTitle("Table " + VariableSingleton.selectedTableId);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_pay_out);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // recycle viewer

        mAdapter = new MyAdapter(VariableSingleton.currentMyTable); //myadadpter
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view); //recycle_view v layout activite, pridat recycle_view s inym id
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        VariableSingleton.myInit();//ine
        mAdapter.notifyDataSetChanged();

    }

}
