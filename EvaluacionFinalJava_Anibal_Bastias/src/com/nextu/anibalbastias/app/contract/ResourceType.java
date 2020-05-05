package com.nextu.anibalbastias.app.contract;

/**
 *
 * @author anibalbastias
 */
public enum ResourceType {
    PATIENT("Pacientes"), 
    DOCTOR("Medicos"), 
    CLINICAL_HISTORY("Historial Clinicos");

    private final String name;

    private ResourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
