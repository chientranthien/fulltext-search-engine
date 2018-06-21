package com.chientt.search.analysis.filter;

import com.chientt.search.engine.SearchEngine;
import com.chientt.search.storage.entity.Data;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author chientt
 */
public class SearchEngineTests {

    @Test
    public void test() {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine
                .index("the Trump administration announced on Tuesday, calling it a cesspool of political bias that targets Israel in particular while ignoring atrocities in other countries.");
        Set<Data> search = searchEngine.search("trump");
        
        System.out.println(search);
    }
}
