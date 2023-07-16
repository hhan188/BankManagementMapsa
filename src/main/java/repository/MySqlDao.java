package repository;

import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.BaseBackService.Bank;
import serviceBussinceManager.CustomerService.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Objects;

public enum MySqlDao {
    INSTANCE;
    private SessionFactory dataSource;


    public void init() throws Exception {
        createMySqlDataSource();
    }

    private void createMySqlDataSource() throws Exception {
        if (Objects.isNull(dataSource)) {
            this.dataSource = DataSourceFactory.createMySqlDataSource();
        }
    }

    public SessionFactory getDataSource() throws Exception {
        if (Objects.isNull(dataSource)) {
            createMySqlDataSource();
        }
        return this.dataSource;
    }

    public void stop() {
        this.dataSource.close();
    }


    public int createNewCustomer(Session connection, Customer customer) {
        CRUD<Customer> insert = new CRUD<>(Customer.class);
        return insert.create(connection, customer);

    }
    public int createNewAccount(Session connection, Account account) {
        CRUD<Account> insert = new CRUD<>(Account.class);
        return insert.create(connection, account);
    }
    public int createNewBank(Session connection, Bank bank) {
        CRUD<Bank> insert = new CRUD<>(Bank.class);
        return insert.create(connection, bank);
    }

}
