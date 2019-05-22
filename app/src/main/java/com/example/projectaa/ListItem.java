package com.example.projectaa;

public class ListItem {
    private String[] mData;

    public ListItem(String[] data) {
        mData = data;
    }

    public ListItem(String param1, String param2) {
        mData = new String[2];
        mData[0] = param1;
        mData[1] = param2;
    }
    public String[] getData() {
        return mData;
    }
    public String getData(int index) {
        return mData[index];
    }
    public void setData(String[] data) {
        mData = data;
    }
}
