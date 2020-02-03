package com.example.myinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myinventory.CustomAdapter.ItemAdapter;
import com.example.myinventory.DatabaseManager.DBManager;
import com.example.myinventory.Helper.DatabaseHelper;
import com.example.myinventory.Model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView rvAllItems;
    private DatabaseHelper dbHelper;

    private List<ItemModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        setTitle("All Items");

        rvAllItems = (RecyclerView) findViewById(R.id.rv_all_inventory);

        dbHelper = new DatabaseHelper(this);

        list = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAllItems.setLayoutManager(layoutManager);
        list = dbHelper.getAll();

        ItemAdapter adapter = new ItemAdapter(this, list);
        rvAllItems.setAdapter(adapter);


    }
}
