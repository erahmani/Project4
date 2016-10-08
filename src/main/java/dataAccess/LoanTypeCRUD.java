package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoanTypeCRUD extends Main{

    public static LoanType create(String name, String interestRate) {
        LoanType loanType = new LoanType();
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            loanType.setName(name);
            loanType.setInterestRate(interestRate);
            session.save(loanType);

            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            return loanType;
        }
    }

    public static List<LoanType> readAll(SessionFactory SESSION_FACTORY) {
        List<LoanType> loanTypeList = null;
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            loanTypeList = session.createQuery("FROM LoanType").list();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            SESSION_FACTORY.close();
        }
        return loanTypeList;
    }

    public static void delete(SessionFactory SESSION_FACTORY, Long id) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            LoanType loanType = (LoanType) session.get(LoanType.class, id);
            session.delete(loanType);
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            SESSION_FACTORY.close();
        }
    }
}
