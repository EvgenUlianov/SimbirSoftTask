package EvgenUlianov.SimbirSoftTask;


import EvgenUlianov.SimbirSoftTask.model.StatisticEntity;
import EvgenUlianov.SimbirSoftTask.service.StatisticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
@Log4j2
public class SimbirSoftTaskApplication implements CommandLineRunner {

	final private String SHUT_UP_COMMAND = "exit";

	@Autowired
	private StatisticService service;

	public static void main(String[] args) {
		SpringApplication.run(SimbirSoftTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean needToShutUp = false;
		do {
			System.out.println("Введите URL:");
			try {
				String url = reader.readLine();
				log.info(url);

				if (url.equalsIgnoreCase(SHUT_UP_COMMAND))
					needToShutUp = true;

				List<StatisticEntity> statisticEntities = service.getStatistic(url);

				System.out.println("Результат:");

				statisticEntities.forEach(System.out::println);

			} catch (IOException e) {
				e.printStackTrace();
				log.error(e);
			}

		} while (!needToShutUp);

	}
}
