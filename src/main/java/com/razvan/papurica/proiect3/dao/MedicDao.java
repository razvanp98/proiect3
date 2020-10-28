package com.razvan.papurica.proiect3.dao;

import com.razvan.papurica.proiect3.entity.Medic;
import com.razvan.papurica.proiect3.entity.Pacient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component("medicDao")
@Scope(scopeName = "singleton")
public class MedicDao implements DaoInterface {

    private Session session;

    // Methods

    @Override
    public Set<Medic> read() {
        refresh();
        session.beginTransaction();

        Query<Medic> medicsQuery = session.createQuery("from Medic");
        Set<Medic> medici = Set.copyOf(medicsQuery.getResultList());

        session.close();
        return medici;
    }

    @Override
    public Object createGet() {
        return new Medic();
    }

    @Override
    public void createDo(Object medic) {
        refresh();
        session.beginTransaction();
        session.save(medic);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Object updateGet(int id) {
        refresh();
        session.beginTransaction();

        Medic targetMedic = session.get(Medic.class, id);

        session.close();
        return targetMedic;
    }

    @Override
    public void updateDo(Object medic) {
        refresh();
        session.beginTransaction();
        session.update(medic);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        refresh();
        session.beginTransaction();

        Medic targetMedic = session.get(Medic.class, id);
        session.delete(targetMedic);
        session.getTransaction().commit();
        session.close();
    }

    // Refresh session

    public void refresh() {
        this.session = getSession();
    }

    // Link methods

    public void link(Medic m, Pacient p) {
        refresh();
        session.beginTransaction();

        m.addPacient(p);
        session.update(m);
        session.getTransaction().commit();
        session.close();

    }

    public void unlink(Medic m, Pacient p) {
        refresh();
        session.beginTransaction();

        m.removePacient(p);
        session.update(m);
        session.getTransaction().commit();
        session.close();
    }
}
