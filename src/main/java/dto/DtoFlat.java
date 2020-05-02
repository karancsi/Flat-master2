package dto;

import model.FlatEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DtoFlat {

    private static List<FlatEntity> flats;

    public static List<FlatEntity> getAllFlat(){
        flats = new ArrayList<>();
        try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) {
            flats = session.createQuery("from FlatEntity", FlatEntity.class).list();
        }catch(Exception e){
            System.out.println("error - getAllFlat");
        }
        return flats;
    }

    public static void addFlatToDatabase(FlatEntity flat){
        Transaction transaction = null;
        try(org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(flat);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }

        }
    }

    public static void deleteFlat(FlatEntity flat){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            FlatEntity deletedFlat = (FlatEntity)session.load(FlatEntity.class,flat.getIdflat());
            session.delete(deletedFlat);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }

        }
    }

    public static void editFlat(FlatEntity flat){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(flat);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

}
