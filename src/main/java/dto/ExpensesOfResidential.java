package dto;


import model.ExpenseEntity;
import model.ResidentialEntity;

import java.util.ArrayList;
import java.util.List;

public class ExpensesOfResidential {

    //EntityLists
    private static List<ResidentialEntity> residentials;
    private static List<ExpenseEntity> expenses;


    //ClassList
    private static List<ExpensesOfResidential> expensesOfResidential;

    //Get
    private static void getResidentials(){
        residentials = DtoResidential.getAllResidential();
    }
    private static void getExpenses(){
        expenses = DtoExpense.getAllExpense();
    }


    //Generating
    public static List<ExpensesOfResidential> generateExpenses(){
        //get
        getResidentials();
        getExpenses();


        //Create new instance
        ExpensesOfResidential generateExpenses;
        expensesOfResidential = new ArrayList<>();

        //generate
        for(ExpenseEntity ex: expenses){
            for (ResidentialEntity res: residentials) {

                //Paring up users with their rented movies
                if(ex.getIdresidential() == res.getIdresidential() ){
                    //new instance of a single rent of a movie by client
                    generateExpenses = new ExpensesOfResidential(

                    );

                    //Adding the new instance to the list of renting by the clients
                    expensesOfResidential.add(generateExpenses);
                }
            }
        }


        //And now you got all the needed rents pared up ^^
        return expensesOfResidential;
    }
}

