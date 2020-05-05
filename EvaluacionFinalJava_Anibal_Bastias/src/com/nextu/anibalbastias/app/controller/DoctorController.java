package com.nextu.anibalbastias.app.controller;

import com.nextu.anibalbastias.app.MainWindow;
import com.nextu.anibalbastias.app.contract.DoctorContract;
import com.nextu.anibalbastias.app.contract.ResourceType;
import com.nextu.anibalbastias.app.controller.listener.ActionResourceListener;
import com.nextu.anibalbastias.app.controller.listener.BaseSearchListener;
import com.nextu.anibalbastias.app.entity.DoctorEntity;
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
public class DoctorController extends MainController implements 
        IOUtils.ScanResourceListener,
        BaseSearchListener<DoctorEntity>,
        DoctorContract {
    
    private ResourceType resourceType = ResourceType.DOCTOR;
    
    public DoctorController() {
        super();
        resourceType = ResourceType.DOCTOR;
        
        if (MainWindow.doctors == null) {
            MainWindow.doctors = new ArrayList<>();
        }
        MainWindow.doctorFound = null;
    }
  
    public void showDoctorManagement() {
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
            showDoctorManagement();
    }
    
    private void createOrUpdateItem(boolean isCreate) {
        print("Ingrese un nombre:\n>");
        String firstName = scanContentTyped();

        print("Ingrese un apellido:\n>");
        String lastName = scanContentTyped();

        print("Ingrese especialidad:\n>");
        String speciality = scanContentTyped();

        if (isCreate) {
            DoctorEntity item = new DoctorEntity(firstName, lastName, speciality);
            insert(item);
            print("\nMedico creado!\n");
        } else {
            print(getAll().toString());
            print("Ingrese Id de medico a modificar:\n>");
            String id = scanContentTyped();
            
            filterDoctor(id, (DoctorEntity doctor) -> {
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setSpeciality(speciality);
                update(doctor);
                print("\nMedico actualizado!\n");
            });
        }
    }
    
    private void removeItem() {
        print("Ingrese id medico para eliminar:\n>");
        String id = scanContentTyped();
        
        DoctorEntity doctor = get(id);
        delete(doctor);
        print("\nMedico eliminado!\n");
    }

    @Override
    public ArrayList<DoctorEntity> getAll() {
        return MainWindow.doctors;
    }

    @Override
    public DoctorEntity get(String id) {
        filterDoctor(id, this);
        return MainWindow.doctorFound;
    }

    @Override
    public void onSearchResource(DoctorEntity item) {
        MainWindow.doctorFound = item;
    }
    
    @Override
    public void update(DoctorEntity item) {
        filterDoctor(item.getId(), (DoctorEntity doctor) -> {
            doctor = item;
        });
    }

    @Override
    public void delete(DoctorEntity item) {
        MainWindow.doctors.remove(item);
    }

    @Override
    public void insert(DoctorEntity item) {
        MainWindow.doctors.add(item);
    }
    
    private void filterDoctor(String id, BaseSearchListener<DoctorEntity> callback) {
        if (MainWindow.doctors != null && !MainWindow.doctors.isEmpty()) {
            MainWindow.doctors.stream().filter((doctor) -> (doctor.getId().equals(id))).forEach((doctor) -> {
                callback.onSearchResource(doctor);
            });
        }
    }
    
    private void checkNotNullItems(ActionResourceListener callback) {
        if (getAll().isEmpty()) {
            print("\nNo hay medicos registrados\n");
        } else {
            callback.onActionResource();
        }
    }
}
