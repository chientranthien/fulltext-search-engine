package com.chientt.search.storage.entity;

import java.util.List;

public class IndexData {
    private String index;
    private List<Long> offset;

    public IndexData() {
    }

    public IndexData(String index, List<Long> offset) {
        this.index = index;
        this.offset = offset;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Long> getOffset() {
        return offset;
    }

    public void setOffset(List<Long> offset) {
        this.offset = offset;
    }
}
