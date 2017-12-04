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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SingleTableAddActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView mTextMessage;
    private Button btn_1;
    private EditText et_sksuka;
    private Context context;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            intent = new Intent(context, SingleTableActivity.class);
            startActivity(intent);
                    return true;


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_table_add);
        context = this;

        this.setTitle("Add item on Table " + VariableSingleton.selectedTableId);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_add_item);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // recycle viewer

        mAdapter = new JustAdapter(VariableSingleton.myMenu); //myadadpter
        recyclerView = (RecyclerView) findViewById(R.id.recycle_add); //recycle_view v layout activite, pridat recycle_view s inym id
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        VariableSingleton.myInit();//ine
        mAdapter.notifyDataSetChanged();


    }

}
