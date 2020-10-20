package com.razvan.papurica.proiect3.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medic", schema = "proiect3")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medic")
    private int id;

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
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "proiect3.medic_pacient",
                joinColumns = @JoinColumn(name = "id_medic"),
                inverseJoinColumns = @JoinColumn(name = "id_pacient"))
    private List<Pacient> pacienti;

    // END Pacient mapping

    // CONSTRUCTORS

    public Medic() {}

    public Medic(String numeMedic, String prenumeMedic, String specializare) {
        this.numeMedic = numeMedic;
        this.prenumeMedic = prenumeMedic;
        this.specializare = specializare;
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(List<Pacient> pacienti) {
        this.pacienti = pacienti;
    }

    // CUSTOM METHODS

    public void addPacient(Pacient pacient) {
        if(this.pacienti == null)
            this.pacienti = new ArrayList<>();
        this.pacienti.add(pacient);
    }

    public void removePacient(Pacient pacient) {
        this.pacienti.removeIf(p -> p.getId() == pacient.getId());
    }
}
