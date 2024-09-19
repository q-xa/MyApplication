package com.example.sj1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView timeTextView = findViewById(R.id.timeTextView);

        // 获取当前系统时间
        String currentTime = getCurrentTime();

        // 在 TextView 中显示时间
        timeTextView.setText(currentTime);
    }

    private String getCurrentTime() {
        // 时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.getDefault());
        return "现在时间: " + sdf.format(new Date());
    }
}
