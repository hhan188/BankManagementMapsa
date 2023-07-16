package repository;

import serviceBussinceManager.BaseBackService.Bank;
import serviceBussinceManager.CustomerService.Customer;
import org.hibernate.Session;
import services.LogService;

import java.util.Objects;


public enum Repository {
    INSTANCE;

    private final LogService logger = LogService.INSTANCE;

    public void init() throws Exception {
        MySqlDao.INSTANCE.init();
    }

    public void stop() {
        MySqlDao.INSTANCE.stop();
    }


    public int createNewCustomer(Customer customer, String logTrack) {
        Session connection = null;
        try {
            connection = MySqlDao.INSTANCE.getDataSource().openSession();
            return MySqlDao.INSTANCE.createNewCustomer(connection, customer);
        } catch (Exception e) {
            String logMessage =
                    "Exception in createNewCustomer --> "
                            + " logTrack: " + logTrack + " e: " + e.getMessage();
            logger.error(logMessage);
            return -1;
        } finally {
            if (!Objects.isNull(connection)) {
                try {
                    connection.close();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }

        }
    }

    public int createNewBank(Bank bank, String logTrack) {
        Session connection = null;
        try {
            connection = MySqlDao.INSTANCE.getDataSource().openSession();
            return MySqlDao.INSTANCE.createNewBank(connection, bank);
        } catch (Exception e) {
            String logMessage =
                    "Exception in createNewBank --> "
                            + " logTrack: " + logTrack + " e: " + e.getMessage();
            logger.error(logMessage);
            return -1;
        } finally {
            if (!Objects.isNull(connection)) {
                try {
                    connection.close();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }

        }
    }
}