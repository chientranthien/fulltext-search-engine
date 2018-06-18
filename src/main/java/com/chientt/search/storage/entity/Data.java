package com.chientt.search.storage.entity;

public class Data extends BaseData {

    private String value;

    public Data() {
    }

    public Data(String _id, String value) {
        super(_id);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
