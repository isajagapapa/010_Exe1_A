package com.example.execise1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        char c;

        switch (nama){
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("08133224455");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("08125533344");
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("08122453344");
                break;
            case "Baim":
                tvnama.setText("Maul M");
                tvnomor.setText("08122453344");
                break;
            case "Aldi":
                tvnama.setText("Intan S");
                tvnomor.setText("08122453344");
                break;
            case "Taher":
                tvnama.setText("Vina R");
                tvnomor.setText("08122453344");
                break;
            case "Nissa":
                tvnama.setText("Gita S");
                tvnomor.setText("08122453344");
                break;
            case "Riziex":
                tvnama.setText("Lutfi M");
                tvnomor.setText("08122453344");
                break;
            case "Bening":
                tvnama.setText("Vian M");
                tvnomor.setText("08122453344");
                break;
            default:
                return;


        }
    }
}