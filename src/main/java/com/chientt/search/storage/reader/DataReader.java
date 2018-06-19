package com.chientt.search.storage.reader;

import com.chientt.search.storage.entity.Data;

/**
 *
 * @author chientt
 */
public interface DataReader {

    Data read(long offet);

}
