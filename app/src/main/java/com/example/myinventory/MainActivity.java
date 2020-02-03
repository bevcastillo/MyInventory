package com.example.myinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnViewAll = (Button) findViewById(R.id.btn_view_all);

        btnAdd.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_add:
                Intent addIntent = new Intent(this, AddItemActivity.class);
                startActivity(addIntent);
                break;
            case R.id.btn_view_all:
                Intent viewAllIntent = new Intent(this, ViewAllActivity.class);
                startActivity(viewAllIntent);
                break;
        }
    }
}
