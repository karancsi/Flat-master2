package service;

import dto.DtoExpense;
import dto.DtoFlat;
import dto.DtoResidential;
import model.ExpenseEntity;
import model.FlatEntity;
import model.ResidentialEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ExPayService {
    private ArrayList<ExpenseEntity> expenses;

    public ArrayList<ExpenseEntity> getExes(){
        expenses = (ArrayList<ExpenseEntity>) DtoExpense.getAllExpense();
        return expenses;
    }

    public void saveExpense(ResidentialEntity res, FlatEntity flat){
    }


    public void addExpense(ExpenseEntity expense){
        DtoExpense.addExpenseToDatabase(expense);
    }

    public void deleteExpense(ExpenseEntity ex){
        DtoExpense.deleteExpense(ex);
    }

    public void editExpense(ExpenseEntity ex){
        DtoExpense.editExpense(ex);
    }

    public ArrayList<ExpenseEntity> getAllExpensesOfRes(ResidentialEntity res) {
        // üres lista létrehozása
        ArrayList<ExpenseEntity> sortedExpenses = new ArrayList<ExpenseEntity>();
        //a választott lakóhoz kilistázza a költségeket <3
        for (ExpenseEntity ee : (ArrayList<ExpenseEntity>) DtoExpense.getAllExpense()) {

            if (ee.getIdresidential() == res.getIdresidential()) {
                sortedExpenses.add(ee);
            }
        }
        return sortedExpenses;
    }

}
