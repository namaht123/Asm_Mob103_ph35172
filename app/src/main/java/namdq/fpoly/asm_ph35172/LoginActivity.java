package namdq.fpoly.asm_ph35172;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import namdp.fpoly.asm_ph35172.R;

public class LoginActivity extends AppCompatActivity {
    TextView tvRegister,tvForgets;
    AppCompatButton btnLogin;

    FirebaseAuth firebaseAuth;
    EditText edEmail, edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);
        edPass = findViewById(R.id.edPassLogin);
        edEmail = findViewById(R.id.edEmailLogin);
        tvForgets = findViewById(R.id.tvForget);

        firebaseAuth = FirebaseAuth.getInstance();


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
        tvForgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
                finish();
            }
        });


        String email = getIntent().getStringExtra("email");
        String pass = getIntent().getStringExtra("pass");

        edPass.setText(pass);
        edEmail.setText(email);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkLogin()) {

                    if (email == null || pass == null) {
                        firebaseAuth.signInWithEmailAndPassword(edEmail.getText().toString(), edPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }


                }

            }
        });


    }

    private boolean checkLogin() {
        if (edEmail.getText().toString().equals("") || edPass.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your information", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}