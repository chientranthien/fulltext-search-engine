package com.chientt.search.analysis.filter;

import com.chientt.search.engine.SearchEngine;
import com.chientt.search.storage.entity.Data;
import java.util.Set;
import org.assertj.core.api.Assertions;
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
        searchEngine
                .index("System Administration is the field of work in which someone manages one or more systems, be they software, hardware, servers or workstations. Its goal is ensuring the systems are running efficiently and effectively.");

        Set<Data> search = searchEngine.search("Administration");
        Assertions.assertThat(search)
                .isNotNull()
                .isNotEmpty();
        Assertions.assertThat(search.size()).isGreaterThanOrEqualTo(2);
    }
}
