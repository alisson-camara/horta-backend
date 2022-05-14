package com.horta.backend.repository;

import java.util.List;
import java.util.Optional;

import com.horta.backend.model.BatteryData;
import org.springframework.data.repository.CrudRepository;

public interface BatteryRepository extends CrudRepository<BatteryData, Long> {
    List<BatteryData> findAll();
    List<BatteryData> findByBoardOrderByDatetime(String board);

    Optional<BatteryData> findTopByOrderByDatetimeDesc();

}