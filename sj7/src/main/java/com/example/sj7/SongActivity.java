package com.example.sj7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnPlay;
private Button btnPause;
private Button btnStop;
private TextView tipmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        initView();
    }

    private void initView() {
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnStop = (Button)findViewById(R.id.btnStop);
        tipmsg = (TextView)findViewById(R.id.tipmsg);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        Intent intent = new Intent(SongActivity.this, MyService.class);
        startService(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("MyService.receiver");
        switch (v.getId()) {
            case R.id.btnPlay:
                intent.putExtra("message", 1);
                tipmsg.setText("《年少的你》播放中...");
                break;
            case R.id.btnPause:
                intent.putExtra("message", 2);
                tipmsg.setText("《年少的你》暂停中...");
                break;
            case R.id.btnStop:
                intent.putExtra("message", 3);
                tipmsg.setText("《年少的你》已停止...");
                break;
            default:
                break;
        }
        sendBroadcast(intent);
    }
}