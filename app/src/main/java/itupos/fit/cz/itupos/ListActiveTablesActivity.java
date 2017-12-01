package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class ListActiveTablesActivity extends AppCompatActivity {
    private Context context;

    //ArrayList<ImageButton> buttons = new ArrayList<>;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_active_tables);

        context = this;



        ImageButton btn[] = new ImageButton[10];

        int i;
        for(i=0; i<5; i++){
            btn[i] = new ImageButton(this);
        }



    }
}
