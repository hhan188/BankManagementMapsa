package repository;

import Exception.BusinessException;
import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.BaseBackService.Bank;
import serviceBussinceManager.BaseBackService.Branch;
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
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/bankmanagment");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "H");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            properties.put(Environment.POOL_SIZE, "5");
          /*  hibernate.connection.url=jdbc:mysql://localhost:3306/Bank?useSSL=false
            hibernate.connection.username=root
            hibernate.connection.password=Ehsan1376
            hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
            hibernate.hbm2ddl.auto=create-drop
            hibernate.show_sql=true*/

            return new Configuration()
                    .setProperties(properties)
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Bank.class)
                    .addAnnotatedClass(Branch.class)
                    .addAnnotatedClass(Transaction.class)
                    .buildSessionFactory();

        } catch (Exception ex) {
            logger.error("build SeesionFactory failed :" + ex);
            System.out.println(ex.getCause());
            ex.printStackTrace();
        }
        return null;
    }


}
