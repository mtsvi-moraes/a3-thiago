package com.bradesco.antifraud.repository;

import com.bradesco.antifraud.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {}
