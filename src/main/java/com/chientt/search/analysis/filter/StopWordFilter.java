package com.chientt.search.analysis.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilter implements TokenFilter {

    public static final String[] STOP_LIST = new String[]{
            "a", "an", "and", "are", "as", "at", "be", "by", "for", "from", "has", "he", "in",
            "is", "it", "its", "of", "on", "that", "the", "to", "was", "were", " will", "with"
    };
    public static final Map<String, String> STOP_WORDS;

    static {
        STOP_WORDS = new HashMap<String, String>();
        for (String s : STOP_LIST) {
            STOP_WORDS.put(s, s);
        }
    }

    public String[] filter(String[] tokens) {
        List<String> filteredTokens = new ArrayList(tokens.length);
        for (String token : tokens) {
            if (!STOP_WORDS.containsValue(token)) {
                filteredTokens.add(token);
            }
        }

        return filteredTokens.toArray(new String[filteredTokens.size()]);
    }
}
