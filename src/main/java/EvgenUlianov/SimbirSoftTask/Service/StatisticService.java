package EvgenUlianov.SimbirSoftTask.service;

import EvgenUlianov.SimbirSoftTask.model.StatisticEntity;
import EvgenUlianov.SimbirSoftTask.repository.RepositoryManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class StatisticService {

    final private MyParser myParser;
    final private RepositoryManager repositoryManager;

    public List<StatisticEntity> getStatistic(String url){

        // можно было как все остальное протянуть через DI с помощью спринга,
        // но решил разбавить ради демонстрации "ручного синглтона"
        // на коммерческом проекте так бы делать не стал
        WordCounter wordCounter = WordCounter.get();

        List<StatisticEntity> result = new ArrayList<>();
        try {

            List<String> words = myParser.parse(url);
            Map<String, Integer> wordCounts = wordCounter.count(words);
            wordCounts.entrySet()
                    .forEach((entry) -> result.add(new StatisticEntity(entry.getKey(), entry.getValue())));

            repositoryManager.saveStatistics(url, result);

        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }

        return result;
    }}
