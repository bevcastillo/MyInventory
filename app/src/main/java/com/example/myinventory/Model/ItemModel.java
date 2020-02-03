package com.example.myinventory.Model;

public class ItemModel {
    int itemId;
    String itemName, itemDesc, itemCat;

    public ItemModel() {
    }


    public ItemModel(String itemName, String itemDesc, String itemCat) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemCat = itemCat;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemCat() {
        return itemCat;
    }

    public void setItemCat(String itemCat) {
        this.itemCat = itemCat;
    }
}
