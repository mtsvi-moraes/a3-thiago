package com.bradesco.antifraud.controller;

import com.bradesco.antifraud.dto.AlertDTO;
import com.bradesco.antifraud.model.Alert;
import com.bradesco.antifraud.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    @Autowired
    private AlertRepository alertRepository;

    @GetMapping("/fetch")
    public ResponseEntity<Alert> fetchFromPythonAndSave() {
        RestTemplate restTemplate = new RestTemplate();

        AlertDTO dto = restTemplate.getForObject("http://127.0.0.1:5000/", AlertDTO.class);

        Alert alert = new Alert();
        alert.setConfidence(dto.getConfidence());
        alert.setIsSpam(dto.is_is_spam());
        alert.setSubject(dto.getSubject());
        alert.setTimeDetected(LocalDateTime.parse(dto.getTime_detected().replace("Z", "")));

        Alert saved = alertRepository.save(alert);
        return ResponseEntity.ok(saved);
    }
}
