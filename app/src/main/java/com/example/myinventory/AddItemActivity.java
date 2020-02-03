package com.example.myinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myinventory.DatabaseManager.DBManager;
import com.example.myinventory.Helper.DatabaseHelper;
import com.example.myinventory.Model.ItemModel;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TextView tvId;
    private EditText etItemName, etItemDesc;
    private Spinner spinnerItemCat;
    private String selectedItemCat;
    private Button btnAddItem;

    private DBManager dbManager;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        setTitle("Add Items");

        tvId = (TextView) findViewById(R.id.tv_item_id);
        etItemName = (EditText) findViewById(R.id.et_item_name);
        etItemDesc = (EditText) findViewById(R.id.et_item_desc);
        spinnerItemCat = (Spinner) findViewById(R.id.spinner_item_cat);
        btnAddItem = (Button) findViewById(R.id.btn_add_item);

        btnAddItem.setOnClickListener(this);
        spinnerItemCat.setOnItemSelectedListener(this);

        dbManager = new DBManager(this);
        dbManager.open();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_add_item:
                if (checkFields()) {
                    final String itemName = etItemName.getText().toString();
                    final String itemDesc = etItemDesc.getText().toString();
                    databaseHelper = new DatabaseHelper(this);

                    ItemModel itemModel = new ItemModel(itemName, itemDesc, selectedItemCat);
                    databaseHelper.insertItem(itemModel);

                    Toast.makeText(this, "Item has been added successfully!", Toast.LENGTH_SHORT).show();
                    //redirect to view all items
                    goViewAll();
                }
        }
    }

    private void goViewAll() {
        startActivity(new Intent(this, ViewAllActivity.class));
    }

    private boolean checkFields() {
        String item_name = etItemName.getText().toString();
        String item_desc = etItemDesc.getText().toString();

        if (item_name.equals("")) {
            Toast.makeText(this, "Item name can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (item_desc.equals("")) {
            Toast.makeText(this, "Item description can not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int sid = parent.getId();

        switch (sid) {
            case R.id.spinner_item_cat:
                selectedItemCat = String.valueOf(parent.getItemAtPosition(position));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
