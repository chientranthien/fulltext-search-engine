package com.chientt.search.storage.writer;

import com.chientt.search.storage.entity.IndexData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class IndexWriterImpl implements IndexWriter {
    private String pathStr;

    public IndexWriterImpl(String pathStr) {
        this.pathStr = pathStr;
    }

    public long write(IndexData indexData) {
        Path path = Paths.get(pathStr);

        return 0;
    }

    public long write(Map<String, IndexData> allIndexData) {
        return 0;
    }
}
