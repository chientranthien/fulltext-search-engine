package com.chientt.search.storage.reader;

import com.chientt.search.storage.entity.Data;
import com.chientt.search.storage.util.DataUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author chientt
 */
public class DataReaderImpl implements DataReader {

    private String pathStr;

    public DataReaderImpl(String pathStr) {
        this.pathStr = pathStr;
    }

    @Override
    public Data read(long offset) {
        Path path = Paths.get(pathStr);
        if (!Files.exists(path)) {
            return null;
        }
        Data result = null;
        try {
            long size = Files.size(path);
            if (size < offset) {
                return null;
            }
            RandomAccessFile raf = new RandomAccessFile(pathStr, "rw");
            raf.seek(offset);
            String line = raf.readLine();

            result = DataUtils.decodeData(line);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
