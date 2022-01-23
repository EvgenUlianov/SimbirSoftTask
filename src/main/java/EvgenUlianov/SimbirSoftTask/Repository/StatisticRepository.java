package EvgenUlianov.SimbirSoftTask.repository;

import EvgenUlianov.SimbirSoftTask.model.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
}
