package EvgenUlianov.SimbirSoftTask.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class MyStringDelimiter {

    final private char [] DELIMITERS;
    final private char [] NUMERALS;
    final private int EXPECTED_MAX_WORD_LENGHT;
    final private int EXPECTED_MAX_WORDS;

    public MyStringDelimiter(@Value("${my.delimiter.delimiters}") String delimiters,
                             @Value("${my.delimiter.numerals}") String numerals,
                             @Value("${my.delimiter.word}") String word,
                             @Value("${my.delimiter.sentence}") String sentence) {

        this.DELIMITERS = delimiters.toCharArray();
        this.NUMERALS = numerals.toCharArray();
        this.EXPECTED_MAX_WORD_LENGHT = Integer.parseInt(word);
        this.EXPECTED_MAX_WORDS = Integer.parseInt(sentence);
    }

    public List<String> split(String bigString){

        final List<String> result = new ArrayList<>(EXPECTED_MAX_WORDS);
        List<Character> currentWord = new ArrayList<>(EXPECTED_MAX_WORD_LENGHT);

        for (char symbol: bigString.toCharArray()) {
            boolean itIsDelimiter = isCategoried(symbol, DELIMITERS);
            boolean itIsNumeral = isCategoried(symbol, NUMERALS);
            if (!itIsDelimiter && !itIsNumeral) {
                currentWord.add(symbol);
            } else if (itIsDelimiter && !currentWord.isEmpty()) {
                char [] chars = new char[currentWord.size()];

                IntStream.range(0, currentWord.size())
                        .forEach((index) -> chars[index] = currentWord.get(index));

                result.add(new String(chars));
                currentWord.clear();
            }
        }
        return result;
    }


    private boolean isCategoried(char symbol, char[] symbolsOfCategory) {
        for (char symbolOfCategory: symbolsOfCategory)
            if (symbolOfCategory == symbol)
                return true;
        return false;
    }

}
