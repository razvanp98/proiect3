package com.razvan.papurica.proiect3.service;

import com.razvan.papurica.proiect3.dao.DaoInterface;
import com.razvan.papurica.proiect3.dao.PacientDao;
import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Medicament;
import com.razvan.papurica.proiect3.entity.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("pacientService")
@Scope(scopeName = "singleton")
public class PacientService {

    @Autowired
    @Qualifier("pacientDao")
    DaoInterface pacientDao;

    private List pacienti;

    // METHODS

    // Show methods
    public List<Pacient> getPacienti() {
        this.pacienti = pacientDao.read();
        return this.pacienti;
    }

    // Create methods

    public Object addPacientGet() {
        return pacientDao.createGet();
    }

    public void addPacientDo(Pacient pacient) {
        pacientDao.createDo(pacient);
    }

    // Update methods

    public Object getPacientUpdate(int pacientId) {
        return pacientDao.updateGet(pacientId);
    }

    public void processPacientUpdate(Pacient pacient) {
        pacientDao.updateDo(pacient);
    }

    // Delete method

    public void deletePacient(int pacientId) {
        pacientDao.delete(pacientId);
    }

    // Link methods

    public void linkMedic(Medic m, Pacient p) {
        PacientDao dao = (PacientDao) this.pacientDao;
        dao.linkMedic(m, p);
    }

    public void unlinkMedic(Medic m, Pacient p) {
        PacientDao dao = (PacientDao) this.pacientDao;
        dao.unlinkMedic(m, p);
    }

    public void linkMedicament(Medicament m, Pacient p) {
        PacientDao dao = (PacientDao) this.pacientDao;
        dao.linkMedicament(p, m);
    }

    public void unlinkMedicament(Medicament m, Pacient p) {
        PacientDao dao = (PacientDao) this.pacientDao;
        dao.unlinkMedicament(p, m);
    }
}
