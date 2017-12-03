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

    private TextView mTextMessage;
    private ImageView currentTableImage;
    private Context context;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_add:
                    //mTextMessage.setText("Vypis aktualnych a priobjednanych veci");
                    //navigationOrderSelectedAction();
                    intent = new Intent(context, SingleTableAddActivity.class);
                    startActivity(intent);
                    return true;
               /* case R.id.navigation_order:
                    //mTextMessage.setText("Vypis aktualnych a priobjednanych veci");
                    //navigationOrderSelectedAction();
                    intent = new Intent(context, SingleTableFinishOrderActivity.class);
                    startActivity(intent);
                    return true;*/
                case R.id.navigation_payout:
                    //mTextMessage.setText(R.string.title_payout);
                    //navigationPayOutSelectedAction();
                    intent = new Intent(context, SingleTablePayOutActivity.class);
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

        /*mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Table");*/
        this.setTitle("Table " + VariableSingleton.selectedTableId);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = (TextView) findViewById(R.id.message);

        VariableSingleton.currentTable = (VariableSingleton.getTables())[VariableSingleton.selectedTableId];
        // currentTableImage = VariableSingleton.selectedTableImage;
        // getActionBar().setTitle(getString(R.string.table_title,VariableSingleton.selectedTableId));

        /** simulacia akcii **/ // todo delete
        VariableSingleton.currentTable.setTaken();
        if(VariableSingleton.currentTable.isTaken()){
         //   currentTableImage.setColorFilter(Color.RED);
        }
        VariableSingleton.currentTable.putOrder("Beer",4);
        VariableSingleton.currentTable.putOrder("Pizza",2);
        VariableSingleton.currentTable.hasBeenPaid("Beer",1);
        VariableSingleton.currentTable.hasBeenPaid("Pizza");
        VariableSingleton.currentTable.putOrder("Pizza",1);
        /**    **/

        VariableSingleton.myInit();
        LinearLayout listLinear = findViewById(R.id.list_linear_right);
        TextView addedViewMain  = new TextView(this);
        addedViewMain.setText("Item");
        addedViewMain.setTextSize(18);
        addedViewMain.setTypeface(Typeface.DEFAULT_BOLD);
        addedViewMain.setId(View.generateViewId());
        addedViewMain.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listLinear.addView(addedViewMain);


        for(Order order : VariableSingleton.currentMyTable.orders.getAllOrders()){
            TextView addedViewLeft  = new TextView(this);
            int addedViewLeftId = View.generateViewId();
            addedViewLeft.setText(order.getName());
            addedViewLeft.setTextSize(18);
            addedViewLeft.setTypeface(Typeface.DEFAULT);
            addedViewLeft.setId(addedViewLeftId);
            addedViewLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            listLinear.addView(addedViewLeft);

            TextView addedViewRight  = new TextView(this);
            int addedViewRightId = View.generateViewId();
            addedViewRight.setText(String.format("%d",order.getAmount()));
            addedViewRight.setTextSize(18);
            addedViewRight.setTypeface(Typeface.DEFAULT);
            addedViewRight.setId(addedViewRightId);
            addedViewRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            listLinear.addView(addedViewRight);


        }
    }

    private void navigationAddSelectedAction(){
        LinearLayout listLinear = findViewById(R.id.list_linear_right);
        listLinear.removeAllViews();
        for(int i = 0; i < 2; i++){ // i < PocetTypovPoloziek (zatial pivo a kura)
            TextView addedView  = new TextView(this);
            int addedViewId = View.generateViewId();
            addedView.setText("hallo hallo Pridavat");
            //addedView.setTextAlignment();

            addedView.setId(addedViewId);
            addedView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            listLinear.addView(addedView);
        }
    }

    private void navigationPayOutSelectedAction(){
        LinearLayout listLinear = findViewById(R.id.list_linear_right);
        listLinear.removeAllViews();
        TextView addedView  = new TextView(this);
        int addedViewId = View.generateViewId();
        addedView.setText("hallo hallo PayOut");
        //addedView.setTextAlignment();
        addedView.setId(addedViewId);
        addedView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listLinear.addView(addedView);
    }


    private void navigationOrderSelectedAction(){
        LinearLayout listLinear = findViewById(R.id.list_linear_right);
        listLinear.removeAllViews();
        for(int i = 0; i < VariableSingleton.menuItems.size(); i++){
            TextView addedView  = new TextView(this);
            int addedViewId = View.generateViewId();
            addedView.setText(VariableSingleton.menuItems.get(i));
            addedView.setTextSize(23);
            addedView.setTypeface(Typeface.DEFAULT_BOLD);
            addedView.setId(addedViewId);
            addedView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            listLinear.addView(addedView);
        }

    }

}
