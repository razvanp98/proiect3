package com.razvan.papurica.proiect3.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "pacient", schema = "proiect3")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacient")
    private int id;

    @Column(name = "cnp")
    private String cnp;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "asigurat")
    private boolean asigurat;

    // Medic mapping - SCHEMA.table resolves the error in Hibernate

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "proiect3.medic_pacient",
            joinColumns = @JoinColumn(name = "id_pacient"),
            inverseJoinColumns = @JoinColumn(name = "id_medic"))
    private List<Medic> medici;


    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name="proiect3.consultatie",
            joinColumns = @JoinColumn(name = "id_pacient"),
            inverseJoinColumns = @JoinColumn(name = "id_medicament"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Medicament> medicamente;

    // END Medic mapping

    // CONSTRUCTORS

    public Pacient() {
    }

    public Pacient(String cnp, String nume, String prenume, String adresa, boolean asigurat) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.asigurat = asigurat;
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public boolean isAsigurat() {
        return asigurat;
    }

    public void setAsigurat(boolean asigurat) {
        this.asigurat = asigurat;
    }

    public List<Medic> getMedici() {
        return medici;
    }

    public void setMedici(List<Medic> medici) {
        this.medici = medici;
    }

    public List<Medicament> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(List<Medicament> medicamente) {
        this.medicamente = medicamente;
    }

    // CUSTOM METHODS

    public void addMedic(Medic medic) {
        if (this.medici == null)
            this.medici = new ArrayList<>();

        this.medici.add(medic);
    }

    public void removeMedic(Medic medic) {
        this.medici.removeIf(m -> m.getId() == medic.getId());
    }

    public void addMedicament(Medicament medicament) {
        if (this.medicamente == null)
            this.medicamente = new ArrayList<>();

        this.medicamente.add(medicament);
    }

    public void removeMedicament(Medicament medicament) {
        this.medicamente.removeIf(m -> m.getId() == medicament.getId());
    }
}
