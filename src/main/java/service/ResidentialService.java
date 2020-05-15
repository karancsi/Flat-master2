package service;

import dto.DtoExpense;
import dto.DtoFlat;
import dto.DtoResidential;
import dto.ExpensesOfResidential;
import model.ExpenseEntity;
import model.FlatEntity;
import model.ResidentialEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@ManagedBean(name="ResidentialService")
@ApplicationScoped
public class ResidentialService {

    public ArrayList<ResidentialEntity> getRes(){
        ArrayList<ResidentialEntity> residentials = (ArrayList<ResidentialEntity>) DtoResidential.getAllResidential();
        return residentials;
    }

    public ArrayList<ExpenseEntity> getAllExpensesOfResidential(ResidentialEntity r) {

        ArrayList<ExpenseEntity> sortedExpEntities = new ArrayList<ExpenseEntity>();
        for (ExpenseEntity eEntity : (ArrayList<ExpenseEntity>) DtoExpense.getAllExpense()) {

            // add if statement
            // if flat is null list all element
            // if flat is not null list only element which parent is the flat id

            //if (residentialEntity.getIdflat() == flat.getIdflat()) {
            sortedExpEntities.add(eEntity);
            //}

        }
        return sortedExpEntities;
    }
//    public ArrayList<ExpensesOfResidential> getAllExpensesOfResidential(ResidentialEntity res){
//
//        ArrayList<ExpensesOfResidential> exRes = (ArrayList<ExpensesOfResidential>) ExpensesOfResidential.generateExpenses();
//
//        ArrayList<ExpensesOfResidential> expensesBySelectedResidential = new ArrayList<>();
//        for(ExpensesOfResidential er: exRes){
//            if(er.getClass() == res.getIdResicential()){
//                expensesBySelectedResidential.add(er);
//            }
//        }
//        return expensesBySelectedResidential;
//    }

    public void addResidential(ResidentialEntity residential){
        DtoResidential.addResidentialToDatabase(residential);
    }



    public void editResidential(ResidentialEntity residential) {
        DtoResidential.editResidential(residential);
    }

    /*public void saveExpense(ResidentialEntity res, FlatEntity flat){
        RentingEntity renting;
        Date dateStart = new Date();

        //Two week long EndTime generation
        Date dateEnd = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateEnd);
        c.add(Calendar.DATE, 14);
        dateEnd = c.getTime();

        //add new instance
        renting = new RentingEntity(selectedClient.getId(),movie.getId(),dateStart,dateEnd);
        DtoRenting.addRentingToDatabase(renting);
        //Apply state changes
        DtoMovie.setMovieToRented(movie.getId());

    }*/
    public void  eviction(ResidentialEntity res, FlatEntity flat){
        DtoResidential.editResidential(res);
        DtoFlat.editFlat(flat);
    }

}
