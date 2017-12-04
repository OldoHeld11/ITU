package itupos.fit.cz.itupos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etPassword;
    LoginActivity loginActivity;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;

    // You can change values of below constants as per need.

    private GestureDetector mGestureDetector;



    // Set touch listener to parent view of activity layout
// Make sure that setContentView is called before setting touch listener.




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        loginActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mGestureDetector = new GestureDetector(context, new SwipeDetector(loginActivity));
        findViewById(R.id.swipe).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Let gesture detector handle the event
                return mGestureDetector.onTouchEvent(event);
            }
        });
        btnLogin = findViewById(R.id.btn_login);
        etPassword = findViewById(R.id.et_password);
        context = this;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = etPassword.getText().toString();
                if (password.equals(VariableSingleton.WAITER_1) ) {
                    //VariableSingleton.myInit();
                    VariableSingleton.setName("WAITER: Davidko");
                    Intent intent = new Intent(context, TablesActivity.class);
                    startActivity(intent);
                }else  if (password.equals(VariableSingleton.WAITER_2) ) {
                   // VariableSingleton.myInit();
                    VariableSingleton.setName("WAITER: Oliverko");
                    Intent intent = new Intent(context, TablesActivity.class);
                    startActivity(intent);
                } else  if (password.equals(VariableSingleton.WAITER_3) ) {
                // VariableSingleton.myInit();
                VariableSingleton.setName("ADMIN: Stulmajster");
                Intent intent = new Intent(context, TablesActivity.class);
                startActivity(intent);
            }  else {
                    VariableSingleton.getInstance().createToast(context);
                    Toast.makeText(context, "Chyba", Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    public void onBackPressed() {
        this.finish();
    }

}
