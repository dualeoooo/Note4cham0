package com.example.android;

import android.os.Bundle;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnlogin, btnregister;
    DatabaseHelper mDatabaseHelper;
    public static EditText editemail, editPass;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editemail = findViewById(R.id.edtemail);
        editPass = findViewById(R.id.edtpass);
        btnlogin = findViewById(R.id.dangnhap);
        btnregister = findViewById(R.id.dangky);
        //Tạo database
//        this.deleteDatabase("SQLite.sqlite");
        mDatabaseHelper = new DatabaseHelper(this);

        //truy vấn database
        mDatabaseHelper.QueryData("CREATE TABLE IF NOT EXISTS SinhVien(Id INTEGER PRIMARY KEY AUTOINCREMENT,Ten VARCHAR(30),Ngay DATE,Id_class INTEGER,Sdt Varchar(11),Email Varchar(30))");
        mDatabaseHelper.QueryData("CREATE TABLE IF NOT EXISTS Class(Id INTEGER PRIMARY KEY AUTOINCREMENT,Malop VARCHAR(30),Tenlop VARCHAR(30))");

        sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        editemail.setText(sharedPreferences.getString("taikhoan",""));
        editPass.setText(sharedPreferences.getString("matkhau",""));

        // bắt sự kiện login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = editemail.getText().toString().trim();
                String b = editPass.getText().toString();
                if (editemail.length() == 0) {
                    Toast.makeText(MainActivity.this, "Vui Lòng Nhập User!", Toast.LENGTH_SHORT).show();
                    editemail.requestFocus();
                    return;
                } else if (editPass.length() == 0){
                    Toast.makeText(MainActivity.this, "Vui Lòng Nhập Password!", Toast.LENGTH_SHORT).show();
                    editPass.requestFocus();
                    return;
                }
                if (a.equals(RegisterActivity.tendk) && b.equals(RegisterActivity.passdk)) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
                if (a.equalsIgnoreCase("admin") && b.equalsIgnoreCase("admin")) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("taikhoan",a);
                    editor.putString("matkhau",b);
                    editor.commit();
                }


            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
