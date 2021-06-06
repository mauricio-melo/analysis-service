package com.totonero.analysisservice.repository;

import com.totonero.analysisservice.repository.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
