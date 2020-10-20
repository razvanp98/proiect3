package com.razvan.papurica.proiect3.service;

import com.razvan.papurica.proiect3.dao.DaoInterface;
import com.razvan.papurica.proiect3.entity.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("medicamentService")
@Scope(scopeName = "singleton")
public class MedicamentService {

    @Autowired
    @Qualifier("medicamentDao")
    DaoInterface medicamentDao;

    private List medicamente;

    // METHODS

    // Show methods
    public List getMedicamente() {
        this.medicamente = medicamentDao.read();
        return this.medicamente;
    }

    // Create methods

    public Object addMedicamentGet() {
        return medicamentDao.createGet();
    }

    public void addMedicamentDo(Medicament medicament) {
        medicamentDao.createDo(medicament);
    }

    // Update methods

    public Object getMedicamentUpdate(int medicamentId) {
        return medicamentDao.updateGet(medicamentId);
    }

    public void processMedicamentUpdate(Medicament medicament) {
        medicamentDao.updateDo(medicament);
    }

    // Delete method

    public void deleteMedicament(int medicamentId) {
        medicamentDao.delete(medicamentId);
    }
}
