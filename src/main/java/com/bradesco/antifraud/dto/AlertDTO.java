package com.bradesco.antifraud.dto;

public class AlertDTO {
    private double confidence;
    private boolean is_spam;
    private String subject;
    private String time_detected;

    public double getConfidence() { return confidence; }
    public void setConfidence(double confidence) { this.confidence = confidence; }

    public boolean is_is_spam() { return is_spam; }
    public void setIs_spam(boolean is_spam) { this.is_spam = is_spam; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getTime_detected() { return time_detected; }
    public void setTime_detected(String time_detected) { this.time_detected = time_detected; }
}
