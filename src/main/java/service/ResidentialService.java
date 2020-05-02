package service;

import dto.DtoFlat;
import dto.DtoResidential;
import dto.ExpensesOfResidential;
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

    public long getDaysFromEnding(Date end){
        Date currentTimeStamp = new Date();
        long difference = 0;
        if(currentTimeStamp.compareTo(end) >= 1){
            long differenceInMillies = Math.abs(currentTimeStamp.getTime() - end.getTime());
            //Get Days gone by since endTime
            difference = TimeUnit.DAYS.convert(differenceInMillies, TimeUnit.MILLISECONDS);
        }
        return difference;
    }



}
