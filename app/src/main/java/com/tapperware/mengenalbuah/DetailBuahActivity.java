package com.tapperware.mengenalbuah;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBuahActivity extends AppCompatActivity {

    @BindView(R.id.imgBuah)
    ImageView imgBuah;
    @BindView(R.id.txtBuah)
    TextView txtBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);
        ButterKnife.bind(this);

        //mengubah nama buah sesuai dengan data dari activity sebelumnya
        txtBuah.setText(getIntent().getStringExtra("nb"));

        //menampilkan gambar dengan Glide dari data gambar activity sebelumnya
        Glide.with(this).load(getIntent().getIntExtra("gb", 0)).into(imgBuah);


        //TODO menjalankan Audio
        Uri uri = Uri.parse("android.resource://"+getPackageName()+ "/"+ getIntent().getIntExtra("ab",0));
        MediaPlayer mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(this, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mPlayer.start();


    }
}
