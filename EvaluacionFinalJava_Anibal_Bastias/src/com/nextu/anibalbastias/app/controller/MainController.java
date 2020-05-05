package com.nextu.anibalbastias.app.controller;

import com.nextu.anibalbastias.app.contract.ResourceType;
import com.nextu.anibalbastias.app.util.IOUtils;
import static com.nextu.anibalbastias.app.util.IOUtils.print;
import static com.nextu.anibalbastias.app.util.IOUtils.scanInt;

/**
 *
 * @author anibalbastias
 */
public class MainController implements 
        IOUtils.ScanListener {
    
    public void showHeader() {
        print("Bienvenido a Clinica NextU - ABS");
        print("================================");
        print("");
        print("Seleccione una opcion para la gestion");
        print("");
    }
    
    public void showManageResources() {
        showHeader();
        print("1. Gestionar Pacientes");
        print("2. Gestionar Medicos");
        print("3. Gestionar Historical Clinico");
        print("4. Salir");
        print("");
        print("> ");
        
        scanInt(4, this, null);
    }
    
    public void showOptionsByResource(ResourceType resourceType) {
        String type = resourceType.getName();
        print("1. Registrar " + type);
        print("2. Mostrar " + type);
        print("3. Modificar " + type);
        print("4. Eliminar " + type);
        print("5. Atras");
        print("");
        print("> ");
    }

    @Override
    public void onSelectedItem(int option) {
        switch (option) {
            // Patient management
            case 1:
                PatientController patientController = new PatientController();
                patientController.showPatientManagement();
                break;
            // Doctor management
            case 2:
                DoctorController doctorController = new DoctorController();
                doctorController.showDoctorManagement();
                break;
            // Clinical History management
            case 3:
                ClinicalHistoryController clinicalHistoryController = new ClinicalHistoryController();
                clinicalHistoryController.showClinicalHistoryManagement();
                break;
            // Exit
            case 4:
                break;
            case 5:
                break;
        }
    }
}
