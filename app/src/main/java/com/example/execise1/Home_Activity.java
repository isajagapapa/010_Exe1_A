package com.example.execise1;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;
    private ListViewAdapter adapter;
    String[] listNama;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    SearchView editsearch;
    String nama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina", "Gita", "Vian", "Lutfi"};

        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
//            Binds strings ke array
            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                nama = classNamaArrayList.get(position).getName();

                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                pm.setOnMenuItemClickListener(Home_Activity.this);

                pm.inflate(R.menu.popup_menu);

                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnviewnm:
                switch (nama) {
                    case "Inayah":
                        Toast.makeText(getApplicationContext(), "08122233344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Ilham":
                        Toast.makeText(getApplicationContext(), "08133224455", Toast.LENGTH_SHORT).show();
                        break;
                    case "Eris":
                        Toast.makeText(getApplicationContext(), "08125533344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Fikri":
                        Toast.makeText(getApplicationContext(), "08122453344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Maul":
                        Toast.makeText(getApplicationContext(), "08126633344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Intan":
                        Toast.makeText(getApplicationContext(), "08122555344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Vina":
                        Toast.makeText(getApplicationContext(), "08125556344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Gita":
                        Toast.makeText(getApplicationContext(), "08199233344", Toast.LENGTH_SHORT).show();
                        break;
                    case "Vian":
                        Toast.makeText(getApplicationContext(), "08122233234", Toast.LENGTH_SHORT).show();
                        break;
                    case "Lutfi":
                        Toast.makeText(getApplicationContext(), "08122969344", Toast.LENGTH_SHORT).show();
                        break;
                }
        }
        return false;
    }
}