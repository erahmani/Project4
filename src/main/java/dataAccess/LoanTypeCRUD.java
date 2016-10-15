package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class LoanTypeCRUD {

    public static void create(LoanType loanType, LinkedList<GrantCondition> grantConditionList) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
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
}
