package EvgenUlianov.SimbirSoftTask.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

    public Map<String, Integer> count(List<String> words){
        Map<String, Integer> result = new TreeMap<>();

        words.stream().forEach((word) -> {
            Integer currentCount = result.get(word);
            if (currentCount == null) {
                result.put(word, 1);
            } else {
                result.put(word, (currentCount + 1));
            }
        });

        return result;
    }

    // SingleTone ++

    // можно было как все остальное протянуть через DI с помощью спринга,
    // но решил разбавить ради демонстрации "ручного синглтона"
    // на коммерческом проекте так бы делать не стал
    private WordCounter(){

    }

    private static class Holder {
        public static final WordCounter OBJECT = new WordCounter();
    }

    public static WordCounter get()  {
        return WordCounter.Holder.OBJECT;
    }

    // SingleTone --
}
