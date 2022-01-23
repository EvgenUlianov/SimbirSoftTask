package EvgenUlianov.SimbirSoftTask.Repository;

import EvgenUlianov.SimbirSoftTask.Model.RequestInfo;
import EvgenUlianov.SimbirSoftTask.Model.StatisticEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
@Log4j2
public class RepositoryManager {

    final private StatisticRepository statisticRepository;
    final private RequestInfoRepository requestInfoRepository;

    public void saveStatistics(String url, List<StatisticEntity> statistics){

        RequestInfo requestInfo = new RequestInfo(url);
        RequestInfo savedRequestInfo = requestInfoRepository.save(requestInfo);

        statistics.forEach((statistic)-> statistic.setRequestInfo(savedRequestInfo));
        statisticRepository.saveAll(statistics);

        log.info(savedRequestInfo.toString());

    }

}
