package com.razvan.papurica.proiect3.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicament", schema = "proiect3")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicament")
    private int id;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "diagnostic")
    private String diagnostic;

    @Column(name = "doza")
    private Integer doza;

    @Column(name = "date")
    private String date;


    @ManyToMany(mappedBy = "medicamenteOfPacient", fetch = FetchType.EAGER)
    private Set<Pacient> pacienti;

    // Constructors

    public Medicament() { }

    public Medicament(String denumire) {
        this.denumire = denumire;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Set<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(Set<Pacient> pacienti) {
        this.pacienti = pacienti;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Integer getDoza() {
        return doza;
    }

    public void setDoza(Integer doza) {
        this.doza = doza;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
