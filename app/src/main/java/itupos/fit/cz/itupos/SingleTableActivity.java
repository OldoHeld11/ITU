package itupos.fit.cz.itupos;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleTableActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView currentTableImage;
    private Table currentTable;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_add:
                    mTextMessage.setText(R.string.title_add);
                    navigationAddSelectedAction();
                    return true;
                case R.id.navigation_order:
                    mTextMessage.setText("Vypis aktualnych a priobjednanych veci");
                    navigationOrderSelectedAction();
                    return true;
                case R.id.navigation_payout:
                    mTextMessage.setText(R.string.title_payout);
                    navigationPayOutSelectedAction();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_table);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = (TextView) findViewById(R.id.message);

        currentTable = VariableSingleton.getTables()[VariableSingleton.selectedTableId];
       // currentTableImage = VariableSingleton.selectedTableImage;

        currentTable.setTaken();
        if(currentTable.isTaken()){
         //   currentTableImage.setColorFilter(Color.RED);
        }
    }

    private void navigationAddSelectedAction(){
        LinearLayout listLinear = findViewById(R.id.list_linear);
        listLinear.removeAllViews();
        TextView addedView  = new TextView(this);
        int addedViewId = View.generateViewId();
        addedView.setText("hallo hallo Pridavat");
        //addedView.setTextAlignment();
        addedView.setId(addedViewId);
        addedView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listLinear.addView(addedView);
    }

    private void navigationPayOutSelectedAction(){
        LinearLayout listLinear = findViewById(R.id.list_linear);
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
        LinearLayout listLinear = findViewById(R.id.list_linear);
        listLinear.removeAllViews();
        TextView addedView  = new TextView(this);
        int addedViewId = View.generateViewId();
        addedView.setText("hallo hallo Order");
        //addedView.setTextAlignment();
        addedView.setId(addedViewId);
        addedView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listLinear.addView(addedView);
    }

}
