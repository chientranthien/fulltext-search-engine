package com.chientt.search.analysis.filter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LowercaseFilterTests {

    TokenFilter tokenFilter = new LowercaseFilter();

    @Test
    public void shouldReturnLowercases() {
        String[] inputs = new String[]{"By", "SENDING", "CHILDREN", "To", "Their", "ROOMS", "AS", "PUNISHMENT",
                "We", "teaCH", "thEM", "thE", "IDEa", "THAt", "ALONENESS", "is", "a", "PRIVATion"};

        String[] expectations = new String[]{"by", "sending", "children", "to", "their", "rooms", "as", "punishment",
                "we", "teach", "them", "the", "idea", "that", "aloneness", "is", "a", "privation"};

        String[] filteredTokens = tokenFilter.filter(inputs);

        Assertions.assertThat(filteredTokens).isEqualTo(expectations);

    }


}
