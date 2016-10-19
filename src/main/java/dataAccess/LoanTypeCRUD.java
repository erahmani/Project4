package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class LoanTypeCRUD {

    public static void create(LoanType loanType, List<GrantCondition> grantConditionList) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loanType);
            loanType.setGrantConditionList(grantConditionList);
            for (GrantCondition grantCondition : grantConditionList) {
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

    public static List<LoanType> read(Integer loanTypeId) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        List<LoanType> loanTypeList = new ArrayList<LoanType>();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM LoanType Where :id is null or id = :id ");
            query.setParameter("id", loanTypeId);
            loanTypeList = query.list();
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