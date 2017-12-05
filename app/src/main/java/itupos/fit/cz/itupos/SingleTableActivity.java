package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleTableActivity extends AppCompatActivity {

    private Context context;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_add:
                    intent = new Intent(context, SingleTableAddActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_payout:
                    intent = new Intent(context, SingleTablePayOutActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.navigation_show_paid:
                    intent = new Intent(context, ShowPaidItemsActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_table);
        context = this;



        this.setTitle("Table " + VariableSingleton.currentMyTable.getTableNumber());
       // VariableSingleton.currentMyTable.orders.setOrder("pizza",2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        LinearLayout listLinearLeft = findViewById(R.id.list_linear_left);
        TextView addedViewMainLeft  = new TextView(this);
        addedViewMainLeft.setText("Item");
        addedViewMainLeft.setTextSize(18);
        addedViewMainLeft.setTypeface(Typeface.DEFAULT_BOLD);
        addedViewMainLeft.setId(View.generateViewId());
        addedViewMainLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listLinearLeft.addView(addedViewMainLeft);

        LinearLayout listLinearRight = findViewById(R.id.list_linear_right);
        TextView addedViewMainRight  = new TextView(this);
        addedViewMainRight.setText("Amount of");
        addedViewMainRight.setTextSize(18);
        addedViewMainRight.setTypeface(Typeface.DEFAULT_BOLD);
        addedViewMainRight.setId(View.generateViewId());
        addedViewMainRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listLinearRight.addView(addedViewMainRight);


        for(Order order : VariableSingleton.currentMyTable.orders.getAllOrders()){
            TextView addedViewLeft  = new TextView(this);
            int addedViewLeftId = View.generateViewId();
            TextView addedViewRight  = new TextView(this);

            addedViewLeft.setText(order.getName());
            addedViewLeft.setTextSize(18);
            addedViewLeft.setTypeface(Typeface.DEFAULT);
            addedViewLeft.setId(addedViewLeftId);
            addedViewLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            int addedViewRightId = View.generateViewId();
            addedViewRight.setText(String.format("%d",order.getAmount()));
            addedViewRight.setTextSize(18);
            addedViewRight.setTypeface(Typeface.DEFAULT);
            addedViewRight.setId(addedViewRightId);
            addedViewRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            listLinearRight.addView(addedViewRight);
            listLinearLeft.addView(addedViewLeft);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
