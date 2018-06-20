package com.chientt.search.storage.entity;

import java.util.ArrayList;
import java.util.List;

public class IndexData {

    private String index;
    private List<Long> offsets;

    public IndexData() {
    }

    public IndexData(String index, long offset) {
        this.index = index;
        this.offsets = new ArrayList<>();
        this.offsets.add(offset);
    }

    public IndexData(String index, List<Long> offset) {
        this.index = index;
        this.offsets = offset;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Long> getOffset() {
        return offsets;
    }

    public void setOffset(List<Long> offset) {
        this.offsets = offset;
    }

    public void addOffset(long offset) {
        this.offsets.add(offset);
    }
}
