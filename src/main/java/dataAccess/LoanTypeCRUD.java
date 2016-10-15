package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class LoanTypeCRUD extends Main {

    public static void create(LoanType loanType, LinkedList<GrantCondition> grantConditionList) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loanType);
            loanType.setGrantConditionList(grantConditionList);
            for (GrantCondition grantCondition: grantConditionList) {
                grantCondition.setLoanType(loanType);
                session.save(grantCondition);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
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
