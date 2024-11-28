package com.example.sj7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer player;
    Context context;
    public MyBroadcastReceiver(Context context) {
        this.context = context;
        createPlayer();
    }

    private void createPlayer() {
        player = MediaPlayer.create(context, R.raw.music);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        int message = intent.getIntExtra("message", 0);
        switch (message) {
            case 1:
                player.start();
                break;
            case 2:
                if(player!= null && player.isPlaying()){
                    player.pause();
                }
                break;
            case 3:
                if(player!= null && player.isPlaying()){
                    player.stop();
                }
                player.release();
                createPlayer();
                break;
        }
    }
}