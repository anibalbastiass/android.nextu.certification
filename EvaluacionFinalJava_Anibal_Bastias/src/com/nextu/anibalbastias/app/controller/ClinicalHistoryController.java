package com.nextu.anibalbastias.app.controller;

import com.nextu.anibalbastias.app.MainWindow;
import com.nextu.anibalbastias.app.contract.ClinicalHistoryContract;
import com.nextu.anibalbastias.app.contract.ResourceType;
import com.nextu.anibalbastias.app.controller.listener.ActionResourceListener;
import com.nextu.anibalbastias.app.controller.listener.BaseSearchListener;
import com.nextu.anibalbastias.app.entity.ClinicalHistoryEntity;
import com.nextu.anibalbastias.app.util.IOUtils;
import static com.nextu.anibalbastias.app.util.IOUtils.clearScreen;
import static com.nextu.anibalbastias.app.util.IOUtils.print;
import static com.nextu.anibalbastias.app.util.IOUtils.scanContentTyped;
import static com.nextu.anibalbastias.app.util.IOUtils.scanInt;
import java.util.ArrayList;

/**
 *
 * @author anibalbastias
 */
public class ClinicalHistoryController extends MainController implements 
        IOUtils.ScanResourceListener,
        BaseSearchListener<ClinicalHistoryEntity>,
        ClinicalHistoryContract {

    private ResourceType resourceType = ResourceType.CLINICAL_HISTORY;

    public ClinicalHistoryController() {
        super();
        resourceType = ResourceType.CLINICAL_HISTORY;
        
        if (MainWindow.clinicalHistories == null) {
            MainWindow.clinicalHistories = new ArrayList<>();
        }
        MainWindow.clinicalHistoryFound = null;
    }
  
    public void showClinicalHistoryManagement() {
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
            showClinicalHistoryManagement();
    }
    
    private void createOrUpdateItem(boolean isCreate) {
        
        // Check if found doctor and patient
        PatientController pController = new PatientController();
        DoctorController dController = new DoctorController();
        
        // Show list of patients and doctors
        print("Pacientes:\n");
        print(pController.getAll().toString());

        print("Medicos:\n");
        print(dController.getAll().toString());
                
        print("Ingrese un Fecha:\n>");
        String date = scanContentTyped();

        print("Ingrese id Doctor:\n>");
        String doctorId = scanContentTyped();

        print("Ingrese id Paciente:\n>");
        String patientId = scanContentTyped();

        print("Ingrese Observacion:\n>");
        String observation = scanContentTyped();
        
        if (pController.get(patientId) != null && dController.get(doctorId) != null) {
            if (isCreate) {
                ClinicalHistoryEntity item = new ClinicalHistoryEntity(date, doctorId, patientId, observation);
                insert(item);
                print("\nHistorial clinico creado!\n");
            } else {
                print(getAll().toString());
                print("Ingrese Id de Historial clinico a modificar:\n>");
                String id = scanContentTyped();

                filterPatient(id, (ClinicalHistoryEntity clinicalHistory) -> {
                    clinicalHistory.setDate(date);
                    clinicalHistory.setDoctorId(doctorId);
                    clinicalHistory.setPatientId(patientId);
                    clinicalHistory.setObservations(observation);
                    update(clinicalHistory);
                    print("\nHistorial clinico actualizado!\n");
                });
            }
        } else {
            print("\nDoctor o paciente no encontrados, intente nuevamente!\n");
        }
    }
    
    private void removeItem() {
        print("Ingrese id Historial clinico para eliminar:\n>");
        String id = scanContentTyped();
        
        ClinicalHistoryEntity patient = get(id);
        delete(patient);
        print("\nHistorial clinico eliminado!\n");
    }

    @Override
    public ArrayList<ClinicalHistoryEntity> getAll() {
        return MainWindow.clinicalHistories;
    }

    @Override
    public ClinicalHistoryEntity get(String id) {
        filterPatient(id, this);
        return MainWindow.clinicalHistoryFound;
    }

    @Override
    public void onSearchResource(ClinicalHistoryEntity item) {
        MainWindow.clinicalHistoryFound = item;
    }
    
    @Override
    public void update(ClinicalHistoryEntity item) {
        filterPatient(item.getCode(), (ClinicalHistoryEntity clinicalHistory) -> {
            clinicalHistory = item;
        });
    }

    @Override
    public void delete(ClinicalHistoryEntity item) {
        MainWindow.clinicalHistories.remove(item);
    }

    @Override
    public void insert(ClinicalHistoryEntity item) {
        MainWindow.clinicalHistories.add(item);
    }
    
    private void filterPatient(String code, BaseSearchListener<ClinicalHistoryEntity> callback) {
        if (MainWindow.clinicalHistories != null && !MainWindow.clinicalHistories.isEmpty()) {
            MainWindow.clinicalHistories.stream().filter((clinicalHistory) -> (clinicalHistory.getCode().equals(code))).forEach((clinicalHistory) -> {
                callback.onSearchResource(clinicalHistory);
            });
        }
    }
    
    private void checkNotNullItems(ActionResourceListener callback) {
        if (getAll().isEmpty()) {
            print("\nNo hay historiales clinicos registrados\n");
        } else {
            callback.onActionResource();
        }
    }
}
