package EvgenUlianov.SimbirSoftTask.Service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void count() {

        // тест на подсчет слов
        List<String> stringList = new ArrayList<>();
        stringList.add("asd");
        stringList.add("asd");
        stringList.add("asd");
        stringList.add("asd");
        stringList.add("asd");
        stringList.add("asd");
        stringList.add("dfg");
        stringList.add("dfg");

        WordCounter counter = WordCounter.get();

        Map<String, Integer> result =  counter.count(stringList);

        assertEquals(result.get("asd"), 6);
    }

    @Test
    void get() {

        // тест на синглтон

        WordCounter counter1 = null, counter2 = null;

        Callable callable1 = () -> WordCounter.get();
        Callable callable2 = () -> WordCounter.get();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Future<WordCounter> chatFuture1 = threadPool.submit(callable1);
        Future<WordCounter> chatFuture2 = threadPool.submit(callable2);

        final int timeOut500 = 500;
        try {
            Thread.sleep(timeOut500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            counter1 = chatFuture1.get();
            counter2 = chatFuture2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertEquals(counter1, counter2);

    }
}