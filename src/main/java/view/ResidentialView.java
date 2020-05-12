package view;

import dto.ExpensesOfResidential;
import model.FlatEntity;
import model.ResidentialEntity;
import service.ResidentialService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="residentialView")
@SessionScoped
public class ResidentialView implements Serializable{

    private ArrayList<ResidentialEntity> residentials;

    private ResidentialEntity selectedResidential;
    private ArrayList<ExpensesOfResidential> selectedResidentialsExpenses;

    private ResidentialEntity editedResidential;
    private ResidentialEntity newResidential = new ResidentialEntity() ;
    private boolean edit = false;

    @ManagedProperty("#{ResidentialService}")
    private ResidentialService service;

    public ArrayList<ResidentialEntity> getResidentials(){
        residentials = service.getRes();
        return residentials;
    }

    public String addRes(){
        newResidential = new ResidentialEntity();
        newResidential.setName(lofasz);
        service.addResidential(newResidential);
        return "residentials?faces-redirect=true\"";
    }

    public String changeEdit(){
        edit = !edit;
        editedResidential = selectedResidential;
        return "res_data?faces-redirect=true";
    }

    public String saveRes(){
        service.editResidential(editedResidential);
        changeEdit();
        return "res_data?faces-redirect=true";
    }

    public String deleteResidential(ResidentialEntity res, FlatEntity flat){
        service.eviction(res,flat);
        return "res_data?faces-redirect=true";
    }

    public void setDataRes(ResidentialEntity res){
        selectedResidential = res;
    }

    //Getters and Setters
    public void setResidentials(ArrayList<ResidentialEntity> res) { this.residentials = res; }

    public void setService(ResidentialService service){
        this.service = service;
    }

    public ResidentialService getService() {
        return service;
    }

    public ResidentialEntity getSelectedResidential() {
        return selectedResidential;
    }

    public void setSelectedResidential(ResidentialEntity selectedResidential) {
        this.selectedResidential = selectedResidential;
    }

    public ResidentialEntity getEditedResidential() {
        return editedResidential;
    }

    public void setEditedResidential(ResidentialEntity editedResidential) {
        this.editedResidential = editedResidential;
    }

    public ResidentialEntity getNewResidential() {
        return newResidential;
    }

    public void setNewResidential(ResidentialEntity newResidential) {
        this.newResidential = newResidential;
    }

    public ArrayList<ExpensesOfResidential> getSelectedResidentialsExpenses() {
        return selectedResidentialsExpenses;
    }

    public void setSelectedResidentialsExpenses(ArrayList<ExpensesOfResidential> selectedResidentialsExpenses) {
        this.selectedResidentialsExpenses = selectedResidentialsExpenses;
    }


    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    private String lofasz;

    public String getLofasz() {
        return lofasz;
    }

    public void setLofasz(String lofasz) {
        this.lofasz = lofasz;
    }
}
