package com.zcc.zqtdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.zcc.zqtdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_username)
    EditText mUsername;

    @BindView(R.id.edt_password)
    EditText mPassword;

    @OnClick(R.id.button) void click(){
        String name = mUsername.getText().toString().trim();
        String password = mUsername.getText().toString().trim();
        if(name.equals("123")&&password.equals("123")){
            Toast.makeText(MainActivity.this, "log in", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
