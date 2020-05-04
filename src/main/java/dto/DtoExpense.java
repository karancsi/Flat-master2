package dto;

import dataConnect.HibernateUtil;
import model.ExpenseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DtoExpense {

    private static List<ExpenseEntity> expenses;

    public static List<ExpenseEntity> getAllExpense(){
        expenses = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            expenses = session.createQuery("from ExpenseEntity ", ExpenseEntity.class).list();
        }catch(Exception e){
            e.getMessage();
        }
        return expenses;
    }

    public static void addExpenseToDatabase(ExpenseEntity expense){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(expense);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }


    public static void deleteExpense(ExpenseEntity expense){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            ExpenseEntity deletedExpense = (ExpenseEntity)session.load(ExpenseEntity.class,expense.getIdexpense());
            session.delete(deletedExpense);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public static void editExpense(ExpenseEntity expense){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(expense);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
