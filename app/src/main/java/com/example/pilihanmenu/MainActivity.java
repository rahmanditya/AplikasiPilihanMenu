package com.example.pilihanmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recMenu;
    private ArrayList<Menu> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recMenu = findViewById(R.id.rec_listmenu);
        initData();

        recMenu.setAdapter(new MenuAdapter(listMenu));
        recMenu.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData(){
        this.listMenu = new ArrayList<>();
        listMenu.add(new Menu("Mie Cakep","Mie dengan rasa gurih pedas"
                ,16000F,R.drawable.mie_cakep,true));
        listMenu.add(new Menu("Mie Ganteng","Mie dengan rasa manis pedas"
                ,15000F,R.drawable.mie_ganteng,true));
        listMenu.add(new Menu("Mie Keren","Mie dengan rasa pedas manis gurih"
                ,17000F,R.drawable.mie_keren,true));
        listMenu.add(new Menu("French Fries","Kentang Goreng dapat request rasa"
                ,10000F,R.drawable.french_fries,true));
        listMenu.add(new Menu("Dimsum","Sajian dimsum asli cina"
                ,9000F,R.drawable.dimsum,true));
        listMenu.add(new Menu("Es Teh","Es Teh manis/tawar"
                ,2500F,R.drawable.es_teh,true));
        listMenu.add(new Menu("Es Jeruk","Es/panas jeruk"
                ,3000F,R.drawable.es_jeruk,true));
        listMenu.add(new Menu("Cappuccino","Sajian Cappuccino es/hangat yang menyemangati hari"
                ,5000F,R.drawable.capp,true));
    }



}