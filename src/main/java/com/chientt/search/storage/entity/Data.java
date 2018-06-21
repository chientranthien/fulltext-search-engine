package com.chientt.search.storage.entity;

public class Data extends BaseData {

    private String value;

    public Data() {
    }

    public Data(String value) {
        this.value = value;
    }

    public Data(String _id, String value) {
        super(_id);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" + "value=" + value + '}';
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (that instanceof Data) {
            return this.equals((Data) that);
        }
        return false;
    }

    public boolean equals(Data that) {
        if (that == null) {
            return false;
        }
        if (!this.get_id().equals(that.get_id())) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
