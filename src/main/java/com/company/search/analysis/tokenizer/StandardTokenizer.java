package com.company.search.analysis.tokenizer;


public class StandardTokenizer implements Tokenizer {

    public String[] extract(String input) {
        return input.split("\\ ");
    }
}
