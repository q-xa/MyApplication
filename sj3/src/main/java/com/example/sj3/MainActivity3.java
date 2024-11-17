package com.example.sj3;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity  {
    RadioGroup sex;
    CheckBox love1,love2,love3;
    Spinner major,banji;
    EditText selectdate,username,password,jieshao;
    Button regBtn;
    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        sex = (RadioGroup) findViewById(R.id.sex);
        love1 = (CheckBox) findViewById(R.id.love1);
        love2 = (CheckBox) findViewById(R.id.love2);
        love3 = (CheckBox) findViewById(R.id.love3);
        major = (Spinner) findViewById(R.id.major);
        banji = (Spinner) findViewById(R.id.banji);
        selectdate = (EditText) findViewById(R.id.selectdate);
        jieshao = (EditText) findViewById(R.id.jieshao);
        regBtn = (Button) findViewById(R.id.regBtn);
//        initBanji();
//        initDatePicker();
        initRegBtnClick();
        Spinner area = (Spinner) findViewById(R.id.banji);
        String[] arr = {"1班", "2班", "3班", "4班"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        area.setAdapter(adapter);
        selectdate = (EditText) findViewById(R.id.selectdate);
        initDatePicker();
//        Click_Button();
    }
    private void initRegBtnClick() {
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Bundle bundle = new Bundle();
                bundle.putString("username",username.getText().toString());
                bundle.putString("password",password.getText().toString());
                RadioButton selectedSex = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                bundle.putString("sex",selectedSex.getText().toString());
                String love="";
                if(love1.isChecked()){
                    love+=love1.getText().toString()+" ";
                }
                if(love2.isChecked()){
                    love+=love2.getText().toString()+" ";
                }
                if(love3.isChecked()){
                    love+=love3.getText().toString()+" ";
                }
                bundle.putString("love",love);
                bundle.putString("major",major.getSelectedItem().toString());
                bundle.putString("banji",banji.getSelectedItem().toString());
                bundle.putString("jieshao",jieshao.getText().toString());
                bundle.putString("selectdate",selectdate.getText().toString());
                Intent intent = new Intent(MainActivity3.this,Reg3Confim.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    //    private void Click_Button() {
//        RadioGroup sex = (RadioGroup) findViewById(R.id.sex);
//        CheckBox sing = (CheckBox) findViewById(R.id.love1);
//        CheckBox dance = (CheckBox) findViewById(R.id.love2);
//        CheckBox draw = (CheckBox) findViewById(R.id.love3);
//        Button regBtn = (Button) findViewById(R.id.regBtn);
//        regBtn.setOnClickListener (this);
//        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                RadioButton rd = (RadioButton) findViewById(checkedId);
//                Toast.makeText(MainActivity2.this, rd.getText() + "单选按钮被选中", Toast.LENGTH_SHORT).show();
//            }
//        });
//        sing.setOnCheckedChangeListener(this);
//        dance.setOnCheckedChangeListener(this);
//        draw.setOnCheckedChangeListener(this);
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.regBtn) {
//            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if(isChecked){
//            Toast.makeText(this,buttonView.getText() + "选项被选中",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this,buttonView.getText() + "选项取消选中",Toast.LENGTH_SHORT).show();
//        }
//    }
    private void initDatePicker() {
        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear = 0;
                int mMonth = 0;
                int mDay = 0;
                String curSelDate = selectdate.getText().toString();
                if(curSelDate==null||curSelDate.equals("")){
                    Calendar ca = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        ca = Calendar.getInstance();
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        mYear = ca.get(Calendar.YEAR);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        mMonth = ca.get(Calendar.MONTH);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        mDay = ca.get(Calendar.DAY_OF_MONTH);
                    }
                }else{
                    mYear = Integer.parseInt(curSelDate.split("-")[0]);
                    mMonth = Integer.parseInt(curSelDate.split("-")[1])-1;
                    mDay = Integer.parseInt(curSelDate.split("-")[2]);
                }
                DatePickerDialog dialog = new DatePickerDialog(MainActivity3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d", year, month+1, dayOfMonth));
                        selectdate.setText(sb);
                    }
                }, mYear, mMonth, mDay);
                dialog.show();
            }
        });
    }

}