package com.company.search.analysis.filter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StopWordFilterTest {
    @Test
    public void test1() {
        String[] inputs = new String[]{
                "By", "sending", "children", "to", "their", "rooms", "as", "punishment",
                "we", "teach", "them", "the", "idea", "that", "aloneness", "is", "a", "privation"};


        LowercaseFilter lowercaseFilter = new LowercaseFilter();
        TokenFilter stopWordFilter = new StopWordFilter();
        inputs=lowercaseFilter.filter(inputs);
        String[] filteredTokens = stopWordFilter.filter(inputs);
        Assertions.assertThat(inputs).doesNotContain(StopWordFilter.STOP_LIST);
    }
}
