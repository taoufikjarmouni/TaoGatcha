package com.example.projetpoo_taogatcha;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.lang.*;

public class MainActivity extends AppCompatActivity {

    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        PnlManager.getManager(this);
        sound= MediaPlayer.create(MainActivity.this,R.raw.tamatown);
        sound.start();
    }
}