package com.chientt.search.storage.writer;

import com.chientt.search.storage.entity.IndexData;
import com.chientt.search.storage.util.DataUtils;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class IndexWriterImpl implements IndexWriter {
    private String pathStr;

    public IndexWriterImpl(String pathStr) {
        this.pathStr = pathStr;
    }

    public long write(IndexData indexData) {
        long offset = 0;
        String encodedIndexData = DataUtils.encodeIndexData(indexData);
        try {
            Path path = Paths.get(pathStr);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            offset = Files.size(path);
            Files.write(path,
                    Arrays.asList(encodedIndexData),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return offset;
    }

    public long write(Map<String, IndexData> allIndexData) {
        long offset = 0;

        Collection<IndexData> indexDataCollection = allIndexData.values();
        List<String> lines = new ArrayList<>();
        for (IndexData indexData : indexDataCollection) {
            String encodeIndexData = DataUtils.encodeIndexData(indexData);
            lines.add(encodeIndexData);
        }
        try {
            Path path = Paths.get(pathStr);
            offset = Files.size(path);
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return offset;
    }
}
