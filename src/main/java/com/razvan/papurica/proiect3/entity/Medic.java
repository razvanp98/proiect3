package com.razvan.papurica.proiect3.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medic", schema = "proiect3")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medic")
    private Integer id;

    @NotNull
    @Column(name = "nume_medic")
    private String numeMedic;

    @NotNull
    @Column(name = "prenume_medic")
    private String prenumeMedic;

    @NotNull
    @Column(name = "specializare")
    private String specializare;


    // START Pacient mapping

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "proiect3.medic_pacient",
                joinColumns = @JoinColumn(name = "id_medic"),
                inverseJoinColumns = @JoinColumn(name = "id_pacient"))
    private Set<Pacient> pacientiOfMedic;

    // END Pacient mapping

    // CONSTRUCTORS

    public Medic() {}

    public Medic(String numeMedic, String prenumeMedic, String specializare) {
        this.numeMedic = numeMedic;
        this.prenumeMedic = prenumeMedic;
        this.specializare = specializare;
    }

    // GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeMedic() {
        return numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }

    public String getPrenumeMedic() {
        return prenumeMedic;
    }

    public void setPrenumeMedic(String prenumeMedic) {
        this.prenumeMedic = prenumeMedic;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public Set<Pacient> getPacienti() {
        return pacientiOfMedic;
    }

    public void setPacienti(Set<Pacient> pacienti) {
        this.pacientiOfMedic = pacienti;
    }

    // CUSTOM METHODS

    public void addPacient(Pacient pacient) {
        if(this.pacientiOfMedic == null)
            this.pacientiOfMedic = new HashSet<>();
        this.pacientiOfMedic.add(pacient);
    }

    public void removePacient(Pacient pacient) {
        this.pacientiOfMedic.removeIf(p -> p.getId().equals(pacient.getId()));
    }
}
