package model;

import javax.persistence.*;

@Entity
@Table(name = "flat", schema = "zsofidb")
public class FlatEntity {
    @javax.persistence.Id
    @Column(name = "idflat")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idflat;

    @Basic
    @Column(name = "floor")
    private int floor;

    @Basic
    @Column(name = "door")
    private int door;

    @Basic
    @Column(name = "size")
    private int size;

    @Basic
    @Column(name = "airspace")
    private int airspace;

    @Basic
    @Column(name = "isempty")
    private int isempty;

    public FlatEntity()
    {

    }

    public FlatEntity(int idflat, int floor, int door, int size, int airspace, int isempty) {
        this.idflat = idflat;
        this.floor = floor;
        this.door = door;
        this.size = size;
        this.airspace = airspace;
        this.isempty = isempty;
    }

    public int getIsempty() {
        return isempty;
    }

    public void setIsempty(int isempty) {
        this.isempty = isempty;
    }

    public int getIdflat() {
        return idflat;
    }

    public void setIdflat(int idflat) {
        this.idflat = idflat;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAirspace() {
        return airspace;
    }

    public void setAirspace(int airspace) {
        this.airspace = airspace;
    }
}
