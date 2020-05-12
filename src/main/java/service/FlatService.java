package service;

import dto.DtoFlat;
import dto.DtoResidential;
import model.FlatEntity;
import model.ResidentialEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name="FlatService")
@ApplicationScoped
public class FlatService {



    public ArrayList<FlatEntity> getFlats(){
         ArrayList<FlatEntity> flats = (ArrayList<FlatEntity>) DtoFlat.getAllFlat();
        return flats;
    }

    public void addFlat(FlatEntity flat){
        DtoFlat.addFlatToDatabase(flat);
    }

    public void deleteFlat(FlatEntity flat){
        DtoFlat.deleteFlat(flat);
    }

    public void editFlat(FlatEntity flat){
        DtoFlat.editFlat(flat);
    }

    public ArrayList<ResidentialEntity> getAllResidentialsOfFlat(FlatEntity flat) {
//unkornis :D jeeeeee
        // üres lista létrehozása
        ArrayList<ResidentialEntity> sortedResidentialEntities = new ArrayList<ResidentialEntity>();
        //az összes lakáshoz kilistázza a lakókat <3
            for (ResidentialEntity residentialEntity : (ArrayList<ResidentialEntity>) DtoResidential.getAllResidential()) {

                if (residentialEntity.getIdflat() == flat.getIdflat()) {
                    sortedResidentialEntities.add(residentialEntity);
                }

        }
        return sortedResidentialEntities;
    }


}
