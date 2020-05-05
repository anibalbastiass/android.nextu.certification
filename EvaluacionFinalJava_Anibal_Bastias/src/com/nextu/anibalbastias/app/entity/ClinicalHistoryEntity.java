package com.nextu.anibalbastias.app.entity;

import java.util.UUID;

/**
 *
 * @author anibalbastias
 */

public class ClinicalHistoryEntity {
    private String code;
    private String date;
    private String patientId;
    private String doctorId;
    private String observations;

    public ClinicalHistoryEntity(
            String date, 
            String patientId, 
            String doctorId, 
            String observations) {
        this.code = UUID.randomUUID().toString();
        this.date = date;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.observations = observations;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Clinical History:" + 
                " code = " + code + 
                ", date = " + date + 
                ", patientId = " + patientId + 
                ", doctorId = " + doctorId + 
                ", observations = " + observations + '\n';
    }
}
