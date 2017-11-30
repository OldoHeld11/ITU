package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by oldo on 29.11.17.
 */

public class TablesActivity extends AppCompatActivity {

    private ImageView table1Image;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        context = this;

        table1Image = findViewById(R.id.stol_1);

        table1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleTableActivity.class);
                Toast.makeText(context, "STOOOOOOOOL JEDNA", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

        });



    }
}
