package view;

import model.ExpenseEntity;
import model.FlatEntity;
import model.ResidentialEntity;
import service.ExPayService;
import service.FlatService;
import service.ResidentialService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="exPayView")
@SessionScoped
public class ExPayView implements Serializable {
    private ArrayList<ExpenseEntity> expenses;
    private ExpenseEntity selectedEx;
    private ExpenseEntity editedEx = new ExpenseEntity();
    private boolean expenseIsEdited = false;
    private ExpenseEntity newExpense = new ExpenseEntity();
    private ArrayList<ExpenseEntity> selectedResidentialsExpenses;
    private ResidentialEntity selectedres; //htmlbe h lássa is a dolgokat!

    @ManagedProperty("#{ExPayService}")
    private ExPayService service;

    public void deleteSelectedExpense(){
        service.deleteExpense(selectedEx);
        selectedEx = null;
    }

    public String addExpense(){
        service.addExpense(newExpense);
        newExpense = new ExpenseEntity();
        return "residential-data?faces-redirect=true";
    }

    public String selectExpenseToEdit(ExpenseEntity exp){
        expenseIsEdited = true;
        editedEx = exp;
        return "residential-data?faces-redirect=true";
    }

    public String saveEditedExpense(){
        service.editExpense(editedEx);
        editedEx = new ExpenseEntity();
        expenseIsEdited = false;
        return "residential-data?faces-redirect=true";
    }

    public String showExpData(ExpenseEntity exp){
        selectedEx = exp;
        getExpensesOfRes();
        return "flat-data?faces-redirect=true";
    }

    public ArrayList<ExpenseEntity> getExpensesOfRes(){
        selectedResidentialsExpenses = service.getAllExpensesOfRes(selectedres);
        return selectedResidentialsExpenses;
    }

    public ArrayList<ExpenseEntity> getAllExpenses() {
        expenses = service.getExes();
        return expenses;
    }

    public void setExpenses(ArrayList<ExpenseEntity> expenses) {
        this.expenses = expenses;
    }

    public ExpenseEntity getSelectedExp() {
        return selectedEx;
    }

    public void setSelectedEps(ExpenseEntity selectedEx) {
        this.selectedEx = selectedEx;
    }

    public ExpenseEntity getEditedEx() {
        return editedEx;
    }

    public void setEditedExp(ExpenseEntity editedEx) {
        this.editedEx = editedEx;
    }

    public boolean isExpenseIsEdited() {
        return expenseIsEdited;
    }

    public void setExpenseIsEdited(boolean expenseIsEdited) {
        this.expenseIsEdited = expenseIsEdited;
    }

    public ExpenseEntity getNewExpense() {
        return newExpense;
    }

    public void setNewExpense(ExpenseEntity newExpense) {
        this.newExpense = newExpense;
    }

    public ExPayService getService() {
        return service;
    }

    public void setService(ExPayService service) {
        this.service = service;
    }
}
