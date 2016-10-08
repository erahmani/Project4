package dataAccess;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

/**
 * Created by dotinschool1 on 10/8/2016.
 */
public class Main {
    protected final static SessionFactory SESSION_FACTORY = null; //new Configuration().
          //  configure().buildSessionFactory();

   public static void main(String[] s) {
        //LoanType loanType = LoanTypeCRUD.create("234", "1");
        //GrantConditionCRUD.create("نشسابشسنتیباشسب", "1", "3", "1", "3", loanType);
        //GrantConditionCRUD.create("ضصثخهصثعضقخف", "3", "4", "1", "3", loanType);
    //    List<GrantCondition> grantConditionList = GrantConditionCRUD.readAll();
      //  System.out.println(grantConditionList);
       System.out.println("منتسیبمسنتیب");
    }
}
