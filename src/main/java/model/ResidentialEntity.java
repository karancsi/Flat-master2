package model;

import javax.persistence.*;

@Entity
@Table(name = "residential", schema = "zsofidb")
public class ResidentialEntity {

    @javax.persistence.Id
    @Column(name = "idresidential")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idresidential;

    @Basic
    @Column(name = "idflat")
    private int idflat;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "startbalance")
    private int startbalance;

    @Basic
    @Column(name = "actualbalance")
    private int actualbalance;

    public ResidentialEntity() {
    }

    public ResidentialEntity(int idresidential, int idflat, String name, int startbalance, int actualbalance) {
        this.idresidential = idresidential;
        this.idflat = idflat;
        this.name = name;
        this.startbalance = startbalance;
        this.actualbalance = actualbalance;

    }

    public int getIdresidential() {
        return idresidential;
    }

    public void setIdresidential(int idresidential) {
        this.idresidential = idresidential;
    }

    public int getIdflat() {
        return idflat;
    }

    public void setIdflat(int idflat) {
        this.idflat = idflat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartbalance() {
        return startbalance;
    }

    public void setStartbalance(int startbalance) {
        this.startbalance = startbalance;
    }

    public int getActualbalance() {
        return actualbalance;
    }

    public void setActualbalance(int actualbalance) {
        this.actualbalance = actualbalance;
    }
}
