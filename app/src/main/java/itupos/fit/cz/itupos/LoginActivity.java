package itupos.fit.cz.itupos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText etPassword;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etPassword = findViewById(R.id.et_password);
        context = this;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = etPassword.getText().toString();
                if (password.equals(VariableSingleton.WAITER_1) || password.equals(VariableSingleton.WAITER_2)) {
                    VariableSingleton.InitializeTables();
                    Intent intent = new Intent(context, TablesActivity.class);
                    startActivity(intent);
                } else {
                    VariableSingleton.getInstance().createToast(context);
                    Toast.makeText(context, "Chyba", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
