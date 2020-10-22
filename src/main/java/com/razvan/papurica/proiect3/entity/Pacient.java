package com.razvan.papurica.proiect3.entity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "pacient", schema = "proiect3")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacient")
    private Integer id;

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
            CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "proiect3.medic_pacient",
            joinColumns = @JoinColumn(name = "id_pacient"),
            inverseJoinColumns = @JoinColumn(name = "id_medic"))
    private Set<Medic> mediciOfPacient;


    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name="proiect3.consultatie",
            joinColumns = @JoinColumn(name = "id_pacient"),
            inverseJoinColumns = @JoinColumn(name = "id_medicament"))
    private Set<Medicament> medicamenteOfPacient;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<Medic> getMedici() {
        return mediciOfPacient;
    }

    public void setMedici(Set<Medic> medici) {
        this.mediciOfPacient = medici;
    }

    public Set<Medicament> getMedicamente() {
        return medicamenteOfPacient;
    }

    public void setMedicamente(Set<Medicament> medicamente) {
        this.medicamenteOfPacient = medicamente;
    }

    // CUSTOM METHODS

    public void addMedic(Medic medic) {
        if (this.mediciOfPacient == null)
            this.mediciOfPacient = new HashSet<>();

        this.mediciOfPacient.add(medic);
    }

    public void removeMedic(Medic medic) {
        this.mediciOfPacient.removeIf(m -> m.getId().equals(medic.getId()));
    }

    public void addMedicament(Medicament medicament) {
        if (this.medicamenteOfPacient == null)
            this.medicamenteOfPacient = new HashSet<>();

        this.medicamenteOfPacient.add(medicament);
    }

    public void removeMedicament(Medicament medicament) {
        this.medicamenteOfPacient.removeIf(m -> m.getId() == medicament.getId());
    }
}
