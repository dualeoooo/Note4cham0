package com.example.android;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        editText = findViewById(R.id.editText);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnViewData = findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);
        //chen lenh Add vao nut them
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                //neu co ghi gi do thi` add binh thuong va kem theo cau lenh phia duoi cung
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {//sai thi` else
                    toastMessage("Ghi gì đi bố!");
                }

            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);
        //them thanh cong thi co noti thong bao
        if (insertData) {
            toastMessage("Okê rồi nhá!");
        } else { //loi he thong thi noti ben duoi
            toastMessage("Có gì đó sai mà lại rất thuyết phục?!");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    }

