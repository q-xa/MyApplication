package com.example.sj8;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class loadImgActivity extends AppCompatActivity {
    private EditText et_path;
    private Button btn_scan;
    private ImageView iv_pic;
    public static final int CHANGE_UI=1;
    public static final int ERROR =2;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==CHANGE_UI){
                Bitmap bitmap= (Bitmap) msg.obj;
                iv_pic.setImageBitmap(bitmap);
            }else if (msg.what==ERROR){
                Toast.makeText(loadImgActivity.this,"图片加载失败",Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_img);
        et_path=findViewById(R.id.et_path);
        btn_scan=findViewById(R.id.btn_scan);
        iv_pic=findViewById(R.id.iv_pic);
        et_path.setText("https://ts1.cn.mm.bing.net/th/id/RC.707d95e36cb042a64e5123a3ae6de4e9?rik=P3he9NhFOPIAEw&riu=http%3a%2f%2f5b0988e595225.cdn.sohucs.com%2fimages%2f20190904%2ff4154397c6c54f3d88e435f16c529886.jpeg&ehk=2PXcmmzk9Gc62VYkjCsdRouRVdbnMeJuhURYc7ybzHs%3d&risl=&pid=ImgRaw&r=0");
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String path=et_path.getText().toString().trim();
                if(TextUtils.isEmpty(path)){
                    Toast.makeText(loadImgActivity.this,"图片路径不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    new Thread(new Runnable() {
                        private HttpURLConnection conn;
                        private Bitmap bitmap;
                        @Override
                        public void run() {
                            try {
                                URL url = new URL(path);
                                conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("GET");
                                conn.setConnectTimeout(5000);
                                int code = conn.getResponseCode();
                                if (code == 200) {
                                    InputStream is = conn.getInputStream();
                                    bitmap = BitmapFactory.decodeStream(is);
                                    Message msg = new Message();
                                    msg.what = CHANGE_UI;
                                    msg.obj = bitmap;
                                    handler.sendMessage(msg);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Message msg = new Message();
                                msg.what = ERROR;
                                handler.sendMessage(msg);
                            }
                            conn.disconnect();
                        }
                    }).start();
                }
            }
        });
    }
}