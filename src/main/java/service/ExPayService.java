package service;

import model.FlatEntity;
import model.ResidentialEntity;

import java.util.Calendar;
import java.util.Date;

public class ExPayService {
    public void saveExpense(ResidentialEntity res, FlatEntity flat){
        // RentingEntity renting;
        Date dateStart = new Date();

        //Two week long EndTime generation
        Date dateEnd = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateEnd);
        c.add(Calendar.DATE, 14);
        dateEnd = c.getTime();

        //add new instance
       /* renting = new RentingEntity(selectedClient.getId(),movie.getId(),dateStart,dateEnd);
        DtoRenting.addRentingToDatabase(renting);
        //Apply state changes
        DtoMovie.setMovieToRented(movie.getId());*/

    }
}
