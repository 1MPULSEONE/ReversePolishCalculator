package it.lovejazz.calculator;

import java.util.List;

public interface Tokenizer {
    List<String> tokenize(String expression);
}
