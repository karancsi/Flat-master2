package view;

import model.FlatEntity;
import model.ResidentialEntity;
import service.FlatService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="flatsView")
@SessionScoped
public class FlatsView implements Serializable {
    private ArrayList<FlatEntity> flats;
    private FlatEntity selectedFlat;
    private FlatEntity editedFlat = new FlatEntity();
    private boolean flatsIsEdited = false;
    private FlatEntity newFlat = new FlatEntity();
    private ArrayList<ResidentialEntity> selectedFlatsResidentials;

    @ManagedProperty("#{FlatService}")
    private FlatService service;


    public void deleteSelectedFlat(){
        service.deleteFlat(selectedFlat);
        selectedFlat = null;
    }

    public String addFlat(){
        service.addFlat(newFlat);
        newFlat = new FlatEntity();
        return "flats?faces-redirect=true";
    }

    public String deleteFlat(FlatEntity flat){
        service.deleteFlat(flat);
        return "flats?faces-redirect=true";
    }

    public String selectFlatToEdit(FlatEntity flat){
        flatsIsEdited = true;
        editedFlat = flat;
        return "flats?faces-redirect=true";
    }

    public String saveEditedFlat(){
        service.editFlat(editedFlat);
        editedFlat = new FlatEntity();
        flatsIsEdited = false;
        return "flats?faces-redirect=true";
    }

    public String showFlatData(FlatEntity flat){
        System.out.println("Selected clients: " + flat.toString());
        selectedFlat = flat;
        getResidentialByFlatId();
        return "client_data?faces-redirect=true";
    }

    public ArrayList<ResidentialEntity> getResidentialByFlatId(){
        selectedFlatsResidentials = service.getAllResidentialsOfFlat(selectedFlat);
        return selectedFlatsResidentials;
    }

    //getsetcuccli
    public ArrayList<FlatEntity> getFlats() {
        flats = service.getFlats();
        return flats;
    }

    public void setFlats(ArrayList<FlatEntity> flats) {
        this.flats = flats;
    }

    public FlatEntity getSelectedFlat() {
        return selectedFlat;
    }

    public void setSelectedFlat(FlatEntity selectedFlat) {
        this.selectedFlat = selectedFlat;
    }

    public FlatEntity getEditedFlat() {
        return editedFlat;
    }

    public void setEditedFlat(FlatEntity editedFlat) {
        this.editedFlat = editedFlat;
    }

    public boolean isFlatsIsEdited() {
        return flatsIsEdited;
    }

    public void setFlatsIsEdited(boolean flatsIsEdited) {
        this.flatsIsEdited = flatsIsEdited;
    }

    public FlatEntity getNewFlat() {
        return newFlat;
    }

    public void setNewFlat(FlatEntity newFlat) {
        this.newFlat = newFlat;
    }

    public FlatService getService() {
        return service;
    }

    public void setService(FlatService service) {
        this.service = service;
    }
}
