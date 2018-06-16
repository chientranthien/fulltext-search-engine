package com.chientt.search.storage.entity;

import java.util.UUID;

public class BaseData {
    private String _id;

    public BaseData() {
        UUID uuid = UUID.randomUUID();
        _id=uuid.toString();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
