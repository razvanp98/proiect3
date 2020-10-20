package com.razvan.papurica.proiect3.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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


    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name="proiect3.consultatie",
            joinColumns = @JoinColumn(name = "id_medicament"),
            inverseJoinColumns = @JoinColumn(name = "id_pacient"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Pacient> pacienti;

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

    public List getPacienti() {
        return pacienti;
    }

    public void setPacienti(List pacienti) {
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
