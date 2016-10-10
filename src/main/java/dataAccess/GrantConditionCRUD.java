package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by dotinschool1 on 10/8/2016.
 */
public class GrantConditionCRUD extends Main {

    public static void create(String name, String minDuration, String maxDuration,
                              String minCost, String maxCost, LoanType loanType) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            GrantCondition grantCondition = new GrantCondition();
            grantCondition.setName(name);
            grantCondition.setMinDuration(minDuration);
            grantCondition.setMaxDuration(maxDuration);
            grantCondition.setMinCost(minCost);
            grantCondition.setMaxCost(maxCost);

            grantCondition.setLoanType(loanType);
            loanType.getGrantConditionList().add(grantCondition);

            session.save(grantCondition);
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

    public static List<GrantCondition> readAll() {
        List<GrantCondition> grantConditionList = null;
        System.out.println(1);
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            grantConditionList = session.createQuery("FROM GrantCondition").list();
            transaction.commit();
            System.out.println(2);
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(3);
            ex.printStackTrace();
        } finally {
            System.out.println(4);
            session.close();
        }
        System.out.println(5);
        return grantConditionList;
    }

    public static void delete(Integer id) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            GrantCondition grantCondition = (GrantCondition) session.get(GrantCondition.class, id);
            session.delete(grantCondition);
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
}
