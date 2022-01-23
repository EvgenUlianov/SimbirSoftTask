package EvgenUlianov.SimbirSoftTask.controllers;

import EvgenUlianov.SimbirSoftTask.model.StatisticEntity;
import EvgenUlianov.SimbirSoftTask.service.StatisticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class Controller {

    @Autowired
    private StatisticService service;

    @GetMapping
    public List<StatisticEntity> getStatistic(@RequestParam(value = "url", required = true) String url){
        log.info(url);
        return service.getStatistic(url);
    }
}
