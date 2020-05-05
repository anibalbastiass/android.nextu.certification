package com.nextu.anibalbastias.app;

import com.nextu.anibalbastias.app.controller.MainController;
import com.nextu.anibalbastias.app.entity.ClinicalHistoryEntity;
import com.nextu.anibalbastias.app.entity.DoctorEntity;
import com.nextu.anibalbastias.app.entity.PatientEntity;
import java.util.ArrayList;

/**
 *
 * @author anibalbastias
 * Main class for load all classes in application
 */

public class MainWindow {

    // Static vars for live data in runtime
    public static ArrayList<PatientEntity> patients;
    public static PatientEntity patientFound;
    
    public static ArrayList<DoctorEntity> doctors;
    public static DoctorEntity doctorFound;
    
    public static ArrayList<ClinicalHistoryEntity> clinicalHistories;
    public static ClinicalHistoryEntity clinicalHistoryFound;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainController mainMenu = new MainController();
        mainMenu.showManageResources();
    }
}
