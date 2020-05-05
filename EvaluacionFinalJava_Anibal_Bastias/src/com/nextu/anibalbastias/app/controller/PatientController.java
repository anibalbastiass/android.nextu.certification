package com.nextu.anibalbastias.app.controller;

import com.nextu.anibalbastias.app.MainWindow;
import com.nextu.anibalbastias.app.contract.PatientContract;
import com.nextu.anibalbastias.app.contract.ResourceType;
import com.nextu.anibalbastias.app.controller.listener.ActionResourceListener;
import com.nextu.anibalbastias.app.controller.listener.BaseSearchListener;
import com.nextu.anibalbastias.app.entity.PatientEntity;
import com.nextu.anibalbastias.app.util.IOUtils;
import static com.nextu.anibalbastias.app.util.IOUtils.clearScreen;
import static com.nextu.anibalbastias.app.util.IOUtils.print;
import static com.nextu.anibalbastias.app.util.IOUtils.scanContentTyped;
import static com.nextu.anibalbastias.app.util.IOUtils.scanInt;
import static com.nextu.anibalbastias.app.util.IOUtils.scanIntTyped;
import java.util.ArrayList;

/**
 *
 * @author anibalbastias
 */

public class PatientController extends MainController implements 
        IOUtils.ScanResourceListener, 
        BaseSearchListener<PatientEntity>,
        PatientContract {

    private ResourceType resourceType = ResourceType.PATIENT;

    public PatientController() {
        super();
        resourceType = ResourceType.PATIENT;
        
        if (MainWindow.patients == null) {
            MainWindow.patients = new ArrayList<>();
        }
        MainWindow.patientFound = null;
    }
  
    public void showPatientManagement() {
        clearScreen();
        showHeader();
        showCRUDMenuByType(resourceType);
    }
    
    public void showCRUDMenuByType(ResourceType resourceType) {
        showOptionsByResource(resourceType);
        scanInt(5, null, this);
    }
    
    @Override
    public void onSelectedResourceItem(int option) {
        boolean showMainMenu = true;
        switch (option) {
            case 1:
                createOrUpdateItem(true);
                break;
            case 2:
                checkNotNullItems(() -> {
                   print(getAll().toString());
                });
                break;
            case 3:
                checkNotNullItems(() -> {
                    createOrUpdateItem(false);
                });
                break;
            case 4:
                checkNotNullItems(() -> {
                    print(getAll().toString());
                    removeItem();
                });
                break;
            case 5:
                showMainMenu = false;
                showManageResources();
                break;
        }
        
        if (showMainMenu)
            showPatientManagement();
    }
    
    private void createOrUpdateItem(boolean isCreate) {
        print("Ingrese un nombre:\n>");
        String firstName = scanContentTyped();

        print("Ingrese un apellido:\n>");
        String lastName = scanContentTyped();

        print("Ingrese edad:\n>");
        int age = scanIntTyped();

        print("Ingrese genero:\n>");
        String gender = scanContentTyped();

        if (isCreate) {
            PatientEntity item = new PatientEntity(firstName, lastName, age, gender);
            insert(item);
            print("\nPaciente creado!\n");
        } else {
            print(getAll().toString());
            print("Ingrese Id de paciente a modificar:\n>");
            String id = scanContentTyped();
            
            filterPatient(id, (PatientEntity patient) -> {
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setAge(age);
                patient.setGender(gender);
                update(patient);
                print("\nPaciente actualizado!\n");
            });
        }
    }
    
    private void removeItem() {
        print("Ingrese id paciente para eliminar:\n>");
        String id = scanContentTyped();
        
        PatientEntity patient = get(id);
        delete(patient);
        print("\nPaciente eliminado!\n");
    }

    @Override
    public ArrayList<PatientEntity> getAll() {
        return MainWindow.patients;
    }

    @Override
    public PatientEntity get(String id) {
        filterPatient(id, this);
        return MainWindow.patientFound;
    }

    @Override
    public void onSearchResource(PatientEntity item) {
        MainWindow.patientFound = item;
    }
    
    @Override
    public void update(PatientEntity item) {
        filterPatient(item.getId(), (PatientEntity patient) -> {
            patient = item;
        });
    }

    @Override
    public void delete(PatientEntity item) {
        MainWindow.patients.remove(item);
    }

    @Override
    public void insert(PatientEntity item) {
        MainWindow.patients.add(item);
    }
    
    private void filterPatient(String id, BaseSearchListener<PatientEntity> callback) {
        if (MainWindow.patients != null && !MainWindow.patients.isEmpty()) {
            MainWindow.patients.stream().filter((patient) -> (patient.getId().equals(id))).forEach((patient) -> {
                callback.onSearchResource(patient);
            });
        }
    }
    
    private void checkNotNullItems(ActionResourceListener callback) {
        if (getAll().isEmpty()) {
            print("\nNo hay pacientes registrados\n");
        } else {
            callback.onActionResource();
        }
    }
}
