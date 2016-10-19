package dataAccess;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtil {
    public final static SessionFactory SESSION_FACTORY = new Configuration().
            configure().buildSessionFactory();
    }
