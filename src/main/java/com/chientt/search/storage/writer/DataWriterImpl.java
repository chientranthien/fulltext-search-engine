package com.chientt.search.storage.writer;

import com.chientt.search.storage.entity.Data;
import com.chientt.search.storage.util.DataUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 *
 * @author chientt
 */
public class DataWriterImpl implements DataWriter {

    private String pathStr;

    public DataWriterImpl(String pathStr) {
        this.pathStr = pathStr;
    }

    @Override
    public long write(Data data) {
        long offset = 0;
        Path path = Paths.get(pathStr);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            offset = Files.size(path);
            String encodedData = DataUtils.encodeData(data);
            Files.write(path, Arrays.asList(encodedData), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return offset;
    }

}
