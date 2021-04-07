package com.example.execise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    boolean emlvld, pwvld;
    Button btnsignin;
    EditText edemail, edpassword;
    TextView tdaftar;
    TextInputLayout pwerr, emlerr;
    String email, password, emailnya, passwordnya, sukses, pwsalah, emailsalah, salah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsignin = findViewById(R.id.btnSignin);
        edemail = findViewById(R.id.EdEmail);
        edpassword = findViewById(R.id.edPassword);
        tdaftar = findViewById(R.id.tvregister);
        emlerr = (TextInputLayout) findViewById(R.id.emaileror);
        pwerr = (TextInputLayout) findViewById(R.id.pweror);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailnya = "admin@mail.com";
                passwordnya = "123456";

                email = edemail.getText().toString();
                password = edpassword.getText().toString();

//                Email
                if (email.isEmpty()){
                    emlerr.setError("Email Tidak Boleh Kosong");
                    emlvld = false;
                }
                else if(!email.equals(emailnya)){
                    emlerr.setError("Harap Masukkan Email Dengan Benar");
                    emlvld = false;
                }
                else {
                    emlvld = true;
                    emlerr.setEnabled(false);
                }

//                Password
                if (password.isEmpty()){
                    pwerr.setError("Email Tidak Boleh Kosong");
                    pwvld = false;
                }
                else if(!password.equals(passwordnya)){
                    pwerr.setError("Harap Masukkan Email Dengan Benar");
                    pwvld = false;
                }
                else if(password.length() < 6){
                    pwerr.setError("Panjang Password Minimal 6 Karakter");
                    pwvld = false;
                }
                else {
                    pwvld = true;
                    pwerr.setEnabled(false);
                }

                if (!emlvld || !pwvld || !email.equals(emailnya) || !password.equals(passwordnya)){
                    Toast.makeText(getApplicationContext(), "Email atau Password Salah", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Home_Activity.class));
            }
        });

        tdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
                startActivity(i);
            }
        });
    }
}