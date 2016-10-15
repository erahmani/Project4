package dataAccess;

import dataAccess.entity.LoanFile;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoanFileCRUD {
    public static void create(LoanFile loanFile) {
        Session session = DBUtil.SESSION_FACTORY.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loanFile);
            transaction.commit();
        } catch (HibernateError e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
