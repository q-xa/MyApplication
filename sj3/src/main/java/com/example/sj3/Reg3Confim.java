package com.example.sj3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Reg3Confim extends AppCompatActivity {
    TextView username, password, sex, love, major, banji, selectdate, jieshao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg3_confim);
        getDataAndShow();
        initBackBtnClick();
        initConfirmBtnClick();
    }



    private void getDataAndShow() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        username = (TextView) findViewById(R.id.username);
        username.setText(bundle.getString("username"));
        password = (TextView) findViewById(R.id.password);
        password.setText(bundle.getString("password"));
        sex = (TextView) findViewById(R.id.sex);
        sex.setText(bundle.getString("sex"));
        love = (TextView) findViewById(R.id.love);
        love.setText(bundle.getString("love"));
        major = (TextView) findViewById(R.id.major);
        major.setText(bundle.getString("major"));
        banji = (TextView) findViewById(R.id.banji);
        banji.setText(bundle.getString("banji"));
        selectdate = (TextView) findViewById(R.id.selectdate);
        selectdate.setText(bundle.getString("selectdate"));
        jieshao = (TextView) findViewById(R.id.jieshao);
        jieshao.setText(bundle.getString("jieshao"));
    }
    private void initBackBtnClick() {
        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Reg3Confim.this.finish();
            }
        });
    }
    private void initConfirmBtnClick() {
        Button confirmBtn = (Button) findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DBHelper dbHelper = new DBHelper(Reg3Confim.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String sql = "insert into user(username, password, sex, love, major, banji, selectdate, jieshao)";
                sql+=" values('"+username.getText()+"','"+password.getText();
                sql+="','"+sex.getText()+"','"+love.getText()+"','"+major.getText()+"','";
                sql+=banji.getText()+"','"+selectdate.getText()+"','"+jieshao.getText()+"')";
                db.execSQL(sql);
                Intent intent = new Intent(Reg3Confim.this, ListUserActivity.class);
               startActivity(intent);
            }
        });
    }
}