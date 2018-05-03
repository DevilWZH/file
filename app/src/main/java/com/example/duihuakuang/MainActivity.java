package com.example.duihuakuang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    // File file = new File("data/data/com.wuyudong.rwinrom/info.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadAccount();
    }

    public void click(View v) {
        // 获取用户输入的账号和密码
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pass = (EditText) findViewById(R.id.et_pass);

        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        // 获取选框组件
        CheckBox cb = (CheckBox) findViewById(R.id.cb);
        // 检测选框是否被勾选
        if (cb.isChecked()) {
            saveAccount(name, pass);
        }
        // 弹Toast提示框
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

    }

    public void saveAccount(String name, String pass) {
        File file = new File("data/data/com.example.duihuakuang/inf.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write((name + "##" + pass).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadAccount() {
        File file = new File("data/data/com.example.duihuakuang/inf.txt");
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                // 把字节流转换为字节流
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        fis));
                String text = br.readLine();
                String[] s = text.split("##");
                // 获取用户输入的账号和密码
                EditText et_name = (EditText) findViewById(R.id.et_name);
                EditText et_pass = (EditText) findViewById(R.id.et_pass);
                et_name.setText(s[0]);
                et_pass.setText(s[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}