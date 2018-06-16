package com.chientt.search.analysis.filter;

public class LowercaseFilter implements TokenFilter {
    public String[] filter(String[] tokens) {
        String[] filteredTokens = new String[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            filteredTokens[i] = token.toLowerCase();
        }

        return filteredTokens;
    }
}
