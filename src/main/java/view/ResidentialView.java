package view;

import dto.ExpensesOfResidential;
import model.ExpenseEntity;
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
    private ArrayList<ExpenseEntity> selectedResidentialsExpenses;

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
        newResidential.setName(név);
        newResidential.setIdflat(idflat);
        newResidential.setStartbalance(start);
        newResidential.setActualbalance(actual);
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

    public ArrayList<ExpenseEntity> getSelectedResidentialsExpenses() {

        selectedResidentialsExpenses = service.getAllExpensesOfResidential(selectedResidential);

        return selectedResidentialsExpenses;
    }

    public void setSelectedResidentialsExpenses(ArrayList<ExpenseEntity> selectedResidentialsExpenses) {
        this.selectedResidentialsExpenses = selectedResidentialsExpenses;
    }

    public String showExpensesData(ResidentialEntity res){
        selectedResidential = res;
        getSelectedResidentialsExpenses();
        return "residential-data?faces-redirect=true";
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

   // ------------------------------------------------------------------------------------------------------------------
    private String név;

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }
    private int start;
    private int actual;
    private int idflat;

    public int getIdflat() {
        return idflat;
    }

    public void setIdflat(int idflat) {
        this.idflat = idflat;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
}
