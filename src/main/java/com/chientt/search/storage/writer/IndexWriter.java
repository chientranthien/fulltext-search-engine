package com.chientt.search.storage.writer;

import com.chientt.search.storage.entity.IndexData;

import java.util.Map;

public interface IndexWriter {

    long write(IndexData indexData);

    long write(Map<String, IndexData> allIndexData);
}
