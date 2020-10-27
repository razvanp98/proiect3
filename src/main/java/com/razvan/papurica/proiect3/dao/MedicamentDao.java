package com.razvan.papurica.proiect3.dao;

import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Medicament;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component("medicamentDao")
public class MedicamentDao implements DaoInterface {

    private Session session;


    // Methods

    @Override
    public Object createGet() {
        return new Medicament();
    }

    @Override
    public void createDo(Object medicament) {
        refresh();
        session.beginTransaction();
        session.save(medicament);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<Medicament> read() {
        refresh();
        session.beginTransaction();

        Query<Medicament> medicamentQuery = session.createQuery("from Medicament");
        Set<Medicament> medicamente = Set.copyOf(medicamentQuery.getResultList());

        session.close();
        return medicamente;
    }

    @Override
    public Object updateGet(int id) {
        refresh();
        session.beginTransaction();

        Medicament targetMedicament = session.get(Medicament.class, id);

        session.close();
        return targetMedicament;
    }

    @Override
    public void updateDo(Object medicament) {
        refresh();
        session.beginTransaction();
        session.update(medicament);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        refresh();
        session.beginTransaction();

        Medicament targetMedicament = session.get(Medicament.class, id);
        session.delete(targetMedicament);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void refresh() {
        this.session = getSession();
    }
}
