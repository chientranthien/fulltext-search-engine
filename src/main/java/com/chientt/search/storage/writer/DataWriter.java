package com.chientt.search.storage.writer;

import com.chientt.search.storage.entity.Data;

/**
 *
 * @author chientt
 */
public interface DataWriter {

    long write(Data data);
}
