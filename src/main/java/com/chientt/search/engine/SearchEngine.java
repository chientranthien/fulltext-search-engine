package com.chientt.search.engine;

import com.chientt.search.analysis.filter.LowercaseFilter;
import com.chientt.search.analysis.filter.TokenFilter;
import com.chientt.search.analysis.tokenizer.StandardTokenizer;
import com.chientt.search.analysis.tokenizer.Tokenizer;
import com.chientt.search.storage.entity.Data;
import com.chientt.search.storage.entity.IndexData;
import com.chientt.search.storage.reader.IndexReader;
import com.chientt.search.storage.reader.IndexReaderImpl;
import com.chientt.search.storage.writer.DataWriter;
import com.chientt.search.storage.writer.DataWriterImpl;
import com.chientt.search.storage.writer.IndexWriter;
import com.chientt.search.storage.writer.IndexWriterImpl;
import java.util.Map;

/**
 *
 * @author chientt
 */
public class SearchEngine {

    Tokenizer tokenizer = new StandardTokenizer();
    TokenFilter tokenFilter = new LowercaseFilter();
    IndexWriter indexWriter = new IndexWriterImpl("index.db");
    DataWriter dataWriter = new DataWriterImpl("data.db");
    IndexReader indexReader = new IndexReaderImpl("index.db");
    private Map<String, IndexData> allIndexes = indexReader.readAll();

    public SearchEngine() {
        allIndexes = indexReader.readAll();
    }

    public void index(String doc) {
        String[] tokens = tokenizer.extract(doc);
        tokens = tokenFilter.filter(tokens);
        long offset = dataWriter.write(new Data(doc));
        for (String token : tokens) {
            IndexData indexData = allIndexes.get(token);
            if (indexData == null) {
                indexData = new IndexData(token, offset);
                allIndexes.put(token, indexData);
            } else {
                indexData.addOffset(offset);
            }

        }

        indexWriter.write(allIndexes);
    }
}
