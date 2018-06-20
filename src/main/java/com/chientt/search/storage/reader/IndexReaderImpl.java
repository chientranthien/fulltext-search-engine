package com.chientt.search.storage.reader;

import com.chientt.search.storage.entity.IndexData;
import com.chientt.search.storage.util.DataUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chientt
 */
public class IndexReaderImpl implements IndexReader {

    private String pathStr;

    public IndexReaderImpl(String pathStr) {
        this.pathStr = pathStr;
    }

    @Override
    public Map<String, IndexData> readAll() {
        Path path = Paths.get(pathStr);
        if (!Files.exists(path)) {
            return Collections.EMPTY_MAP;
        }
        Map<String, IndexData> result = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                IndexData indexData = DataUtils.decodeIndexData(line);
                result.put(line, indexData);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
