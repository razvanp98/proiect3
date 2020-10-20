package com.razvan.papurica.proiect3.dao;

import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Medicament;
import com.razvan.papurica.proiect3.entity.Pacient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("pacientDao")
@Scope(scopeName = "singleton")
public class PacientDao implements DaoInterface {

    private Session session;

    // Methods

    @Override
    public Object createGet() {
        return new Pacient();
    }

    @Override
    public void createDo(Object pacient) {
        refresh();
        session.beginTransaction();
        session.save(pacient);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List read() {
        refresh();
        session.beginTransaction();

        Query pacientQuery = session.createQuery("from Pacient");
        List pacienti = pacientQuery.getResultList();

        session.close();
        return pacienti;
    }

    @Override
    public Object updateGet(int id) {
        refresh();
        session.beginTransaction();

        Pacient targetPacient = session.get(Pacient.class, id);

        session.close();
        return targetPacient;
    }

    @Override
    public void updateDo(Object pacient) {
        refresh();
        session.beginTransaction();
        session.update(pacient);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        refresh();
        session.beginTransaction();

        Pacient targetPacient = session.get(Pacient.class, id);
        session.delete(targetPacient);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void refresh() {
        this.session = getSession();
    }

    // Linking methods for entity.Medic and entity.Medicament

    public void linkMedic(Medic m, Pacient p) {
        refresh();
        session.beginTransaction();

        p.addMedic(m);
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }

    public void unlinkMedic(Medic m, Pacient p) {
        refresh();
        session.beginTransaction();

        p.removeMedic(m);
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }

    public void linkMedicament(Pacient p, Medicament m) {
        refresh();
        session.beginTransaction();

        p.addMedicament(m);
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }

    public void unlinkMedicament(Pacient p, Medicament m) {
        refresh();
        session.beginTransaction();

        p.removeMedicament(m);
        session.update(p);
        session.getTransaction().commit();
        session.close();
    }
}
