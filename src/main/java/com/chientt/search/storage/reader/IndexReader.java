package com.chientt.search.storage.reader;

import com.chientt.search.storage.entity.IndexData;
import java.util.Map;

public interface IndexReader {

    Map<String, IndexData> readAll();
}
