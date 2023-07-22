package repository;

import Exception.BusinessException;
import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.BaseBackService.Bank;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;
import serviceBussinceManager.TransactionManagmentService.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Configuration;
import services.LogService;

import java.util.Properties;

public class DataSourceFactory {
    private static final LogService logger = LogService.INSTANCE;

    static SessionFactory createMySqlDataSource() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/Hanieh");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "H@nieh74!");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.USE_QUERY_CACHE,"true");
            properties.put(Environment.USE_SECOND_LEVEL_CACHE , "true");
            properties.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");


            return new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Bank.class)
                    .addAnnotatedClass(Branch.class)
                    .addAnnotatedClass(Transaction.class)
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();

        } catch (Exception ex) {
            logger.error("build SeesionFactory failed :" + ex);
            System.out.println(ex.getCause());
            ex.printStackTrace();
        }
        return null;
    }


}
