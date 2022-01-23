package EvgenUlianov.SimbirSoftTask.Repository;

import EvgenUlianov.SimbirSoftTask.Model.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
}
