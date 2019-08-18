package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edttendk, edtpassdk, edtconfirmpass;
    Button btndangky;
    public static String tendk, passdk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edttendk = findViewById(R.id.edtuserdk);
        edtpassdk = findViewById(R.id.edtpassdk);
        edtconfirmpass = findViewById(R.id.edtconfirm);
        btndangky = findViewById(R.id.btnconfirm);
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tendk = edttendk.getText().toString().trim();
                passdk = edtpassdk.getText().toString().trim();
                if (tendk.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "Vui Lòng Nhập Tài Khoản", Toast.LENGTH_SHORT).show();
                    edttendk.requestFocus();
                    return;
                } else if (passdk.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "Vui Lòng Nhập Password", Toast.LENGTH_SHORT).show();
                    edtpassdk.requestFocus();
                    return;
                } else if (edtconfirmpass.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "Vui Lòng Nhập Xác Nhận Tài Khoản", Toast.LENGTH_SHORT).show();
                    edtconfirmpass.requestFocus();
                    return;

                } else {
                    Toast.makeText(RegisterActivity.this, "Đăng Ký Thành Công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
