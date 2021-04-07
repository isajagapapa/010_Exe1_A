package com.example.execise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class DaftarActivity extends AppCompatActivity {

    Button btl, dftr;
    EditText almt, eml, enm, epw, erpw;
    TextInputLayout almterr, emlerr, nmerr, pwerr, rpwerr;
    RadioButton rblaki, rbperem, rbislm, rbktl, rbkrsn, rbhd, rbbd, rbkong, rbkpr;
    RadioGroup agm1, agm2, agm3, jnsklm;
    String agm = "", jnsk = "";
    private int ckagm, ckjk;
    boolean cek = true, nmvld = false,
            emlvld = false, pwvld = false,
            rpwvld = false, almvld =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        enm = (EditText) findViewById(R.id.ednama);
        almt = (EditText) findViewById(R.id.edalamat);
        eml = (EditText) findViewById(R.id.edeemail);
        epw = (EditText) findViewById(R.id.edpass);
        erpw = (EditText) findViewById(R.id.edepass);
        jnsklm = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        agm1 = (RadioGroup) findViewById(R.id.rgagama1);
        agm2 = (RadioGroup) findViewById(R.id.rgAgama2);
        agm3 = (RadioGroup) findViewById(R.id.rgAgama3);
        rblaki = (RadioButton) findViewById(R.id.rbLaki);
        rbperem = (RadioButton) findViewById(R.id.rbPerempuan);
        rbislm = (RadioButton) findViewById(R.id.rbIslam);
        rbktl = (RadioButton) findViewById(R.id.rbKatolik);
        rbkrsn = (RadioButton) findViewById(R.id.rbKristen);
        rbkong = (RadioButton) findViewById(R.id.rbKonghucu);
        rbhd = (RadioButton) findViewById(R.id.rbHindu);
        rbbd = (RadioButton) findViewById(R.id.rbBudha);
        rbkpr = (RadioButton) findViewById(R.id.rbKepercayaan);
        nmerr = (TextInputLayout) findViewById(R.id.ednamaerror);
        almterr = (TextInputLayout) findViewById(R.id.alamaterror);
        emlerr = (TextInputLayout) findViewById(R.id.emailerror);
        pwerr = (TextInputLayout) findViewById(R.id.passeror);
        rpwerr = (TextInputLayout) findViewById(R.id.repasseror);
        btl = (Button) findViewById(R.id.btBatal);
        dftr = (Button) findViewById(R.id.btDaftar);


//        Agama
        agm1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && cek) {
                    cek = false;
                    agm2.clearCheck();
                    agm3.clearCheck();
                    ckagm = checkedId;
                }
                cek = true;
            }
        });
        agm2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && cek) {
                    cek = false;
                    agm1.clearCheck();
                    agm3.clearCheck();
                    ckagm = checkedId;
                }
                cek = true;
            }
        });
        agm3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && cek) {
                    cek = false;
                    agm1.clearCheck();
                    agm2.clearCheck();
                    ckagm = checkedId;
                }
                cek = true;
            }
        });

//        Jenis Kelamin
        jnsklm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && cek) {
                    cek = false;
                    ckjk = checkedId;
                }
                cek = true;
            }
        });

        dftr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int j = ckjk;
                if (j == R.id.rbLaki) {
                    jnsk = "Laki-Laki";
                } else if (j == R.id.rbPerempuan) {
                    jnsk = "Perempuan";
                }

                int i = ckagm;
                if (i == R.id.rbIslam) {
                    agm = "Islam";
                } else if (i == R.id.rbKatolik) {
                    agm = "Katolik";
                } else if (i == R.id.rbKristen) {
                    agm = "Kristen";
                } else if (i == R.id.rbKonghucu) {
                    agm = "Konghucu";
                } else if (i == R.id.rbHindu) {
                    agm = "Hindu";
                } else if (i == R.id.rbBudha) {
                    agm = "Budha";
                } else if (i == R.id.rbKepercayaan) {
                    agm = "Aliran Kepercayaan";
                }



                if (enm.getText().toString().isEmpty() || almt.getText().toString().isEmpty() || eml.getText().toString().isEmpty() || epw.getText().toString().isEmpty() || erpw.getText().toString().isEmpty() || agm.isEmpty() || jnsk.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_SHORT).show();
                }

                if (enm.getText().toString().isEmpty()) {
                    nmerr.setError("Nama Tidak Boleh Kosong");
                    nmvld = false;
                } else {
                    nmerr.setErrorEnabled(false);
                    nmvld = true;
                }
                if (almt.getText().toString().isEmpty()) {
                    almterr.setError("Alamat Tidak Boleh Kosong");
                    almvld = false;
                } else {
                    almterr.setErrorEnabled(false);
                    almvld = true;
                }
                if (eml.getText().toString().isEmpty()) {
                    emlerr.setError("Email Tidak Boleh Kosong");
                    emlvld = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(eml.getText().toString()).matches()) {
                    emlerr.setError("Harap Masukkan Email Dengan Benar");
                    emlvld = false;
                } else {
                    emlvld = true;
                    emlerr.setErrorEnabled(false);
                }
                if (epw.getText().toString().isEmpty()) {
                    pwerr.setError("Password Tidak Boleh Kosong");
                    pwvld = false;
                } else if (epw.getText().length() < 6) {
                    pwerr.setError("Panjang Password Minimal 6 Karakter");
                    pwvld = false;
                } else {
                    pwvld = true;
                    pwerr.setErrorEnabled(false);
                }
                if (erpw.getText().toString().isEmpty()) {
                    rpwerr.setError("Re-Password Tidak Boleh Kosong");
                    rpwvld = false;
                } else if (erpw.getText().length() < 6) {
                    rpwerr.setError("Panjang Re-Password Minimal 6 Karakter");
                    rpwvld = false;
                } else if (!erpw.getText().toString().equals(epw.getText().toString())) {
                    rpwerr.setError("Password Tidak Sama");
                    rpwvld = false;
                } else {
                    rpwvld = true;
                    rpwerr.setErrorEnabled(false);
                }

                if (nmvld && almvld && emlvld && pwvld && rpwvld && !agm.isEmpty() && !jnsk.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                    Intent x = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(x);
                }
            }
        });

        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}