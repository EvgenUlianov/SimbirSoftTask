package EvgenUlianov.SimbirSoftTask.repository;

import EvgenUlianov.SimbirSoftTask.model.RequestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestInfoRepository extends JpaRepository<RequestInfo, Long> {
}
