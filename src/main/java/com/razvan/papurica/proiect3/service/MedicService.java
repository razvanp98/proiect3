package com.razvan.papurica.proiect3.service;

import com.razvan.papurica.proiect3.dao.DaoInterface;
import com.razvan.papurica.proiect3.dao.MedicDao;
import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("medicService")
public class MedicService {

    @Autowired
    @Qualifier("medicDao")
    DaoInterface medicDao;

    private List medici;

    // METHODS

    // Show methods
    public List<Medic> getMedics() {
        this.medici = medicDao.read();
        return this.medici;
    }

    // Create methods

    public Object addMedicGet() {
        return medicDao.createGet();
    }

    public void addMedicDo(Medic medic) {
        medicDao.createDo(medic);
    }

    // Update methods

    public Object getMedicUpdate(int medicId) {
        return medicDao.updateGet(medicId);
    }

    public void processMedicUpdate(Medic medic) {
        medicDao.updateDo(medic);
    }

    // Delete method
    public void deleteMedic(int medicId) {
        medicDao.delete(medicId);
    }

    // Link methods

    public void linkPacient(Medic m, Pacient p) {
        MedicDao dao = (MedicDao) this.medicDao;
        dao.link(m, p);
    }

    public void unlinkPacient(Medic m, Pacient p) {
        MedicDao dao = (MedicDao) this.medicDao;
        dao.unlink(m, p);
    }
}
