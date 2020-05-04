package dto;

import dataConnect.HibernateUtil;
import model.ResidentialEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DtoResidential {

    private static List<ResidentialEntity> residentials;

    public static List<ResidentialEntity> getAllResidential(){
        residentials = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            residentials = session.createQuery("from ResidentialEntity ", ResidentialEntity.class).list();
        }catch(Exception e){
            e.getMessage();
        }
        return residentials;
    }

    public static void addResidentialToDatabase(ResidentialEntity residential){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(residential);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public static void deleteResidential(int residentialId){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            ResidentialEntity deletedResidential = (ResidentialEntity) session.load(ResidentialEntity.class, residentialId);
            session.delete(deletedResidential);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.getMessage();
        }
    }
    public static void editResidential(ResidentialEntity res){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(res);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
