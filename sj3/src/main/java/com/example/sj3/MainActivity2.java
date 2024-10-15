package com.example.sj3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Click_Button();

    }

    private void Click_Button() {
        RadioGroup wex = (RadioGroup) findViewById(R.id.sex);
        CheckBox computer = (CheckBox) findViewById(R.id.computer);
        CheckBox software = (CheckBox) findViewById(R.id.software);
        CheckBox communication = (CheckBox) findViewById(R.id.communication);
        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(this);
        wex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup Group,@IdRes int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);{
                    Toast.makeText(MainActivity2.this,  rb.getText()+"单选按钮被选中了" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        computer.setOnCheckedChangeListener(this);
        software.setOnCheckedChangeListener(this);
        communication.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:

                // TODO: register user
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
                    Toast.makeText(this, buttonView.getText() + "选项被选中了", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, buttonView.getText() + "选项被取消了", Toast.LENGTH_SHORT).show();
                }
    }
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isCheck) {
//                if (isCheck) {
//                    Toast.makeText(this, buttonView.getText() + "选项被选中了", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, buttonView.getText() + "选项被取消了", Toast.LENGTH_SHORT).show();
//                }
//    }
}