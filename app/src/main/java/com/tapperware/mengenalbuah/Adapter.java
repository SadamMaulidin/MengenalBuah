package com.tapperware.mengenalbuah;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //TODO 1 membuat variable untuk menampung data pada saat object dibuat dan membawa data menggunkan
    Context context;
    int[] gambarBuah,suaraBuah;
    String[] namaBuah;

    //TODO 2 membuat contructor untuk variable yang sudah dibuat agar dapat menampung parameter

    public Adapter(Context context, int[] gambarBuah, int[] suaraBuah, String[] namaBuah) {
        this.context = context;
        this.gambarBuah = gambarBuah;
        this.suaraBuah = suaraBuah;
        this.namaBuah = namaBuah;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //digunakan untuk menentukan tampilan dari adapter
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_buah, viewGroup, false);
         //memberitahukan recyclerview bahwa kita menggunakan view yang telah kita buat
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        //mengubah namaBUah
        viewHolder.txtNamaBuah.setText(namaBuah[i]);
        Glide.with(context).load(gambarBuah[i]).into(viewHolder.imgNamaBuah);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailBuahActivity.class);
                pindah.putExtra("nb", namaBuah[i]);
                pindah.putExtra("gb", gambarBuah[i]);
                pindah.putExtra("ab", suaraBuah[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarBuah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //meng koneksikan widget buah kedalam adapter
        TextView txtNamaBuah;
        ImageView imgNamaBuah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //mnghubungkan widget ke dalam variable ynag telah dibuat diatas
            txtNamaBuah = itemView.findViewById(R.id.txtNamaBuah);
            imgNamaBuah = itemView.findViewById(R.id.imgBuah);
        }
    }
}

