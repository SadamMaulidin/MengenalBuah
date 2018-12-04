package com.tapperware.mengenalbuah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.sql.Struct;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //TODO 2 meng-inisiasikan widget recyclerview
    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;


    //TODO 3 membuat variable
    String namaBuah[] = {"alpukat", "apel", "ceri", "durian", "jambu air", "manggis", "stroberry"};
    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};
    int suara_buah[]= {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //TODO 4 membuat object adapter agar bisa digunakan
        com.tapperware.mengenalbuah.Adapter adapter = new com.tapperware.mengenalbuah.Adapter(this, gambar_buah, suara_buah,namaBuah);

        //TODO 5 men setting recyclerview dan memasukkan adapter ke recyclerview
        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleView.setAdapter(adapter);
    }
}
