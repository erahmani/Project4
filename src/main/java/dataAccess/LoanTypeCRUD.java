package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoanTypeCRUD {

    public static void create(LoanType loanType, LinkedList<GrantCondition> grantConditionList) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println(loanType);
            session.save(loanType);
            loanType.setGrantConditionList(grantConditionList);
            for (GrantCondition grantCondition : grantConditionList) {
                System.out.println(grantCondition);
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

    public static List<LoanType> searchAll() {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        List<LoanType> loanTypeList = new ArrayList<LoanType>();
        try {
            transaction = session.beginTransaction();
            loanTypeList = session.createQuery("From LoanType").list();
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return loanTypeList;
        }
    }
}