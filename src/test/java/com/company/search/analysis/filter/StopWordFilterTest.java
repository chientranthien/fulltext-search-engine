package com.company.search.analysis.filter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StopWordFilterTest {
    @Test
    public void test1() {
        String[] inputs = new String[]{
                "By", "sending", "children", "to", "their", "rooms", "as", "punishment",
                "we", "teach", "them", "the", "idea", "that", "aloneness", "is", "a", "privation"};


        TokenFilter tokenFilter = new StopWordFilter();
        String[] filteredTokens = tokenFilter.filter(inputs);
        Assertions.assertThat(inputs).doesNotContain(StopWordFilter.STOP_LIST);
    }
}
