package repository;


import org.hibernate.query.Query;
import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.BaseBackService.Bank;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import serviceBussinceManager.TransactionManagmentService.Transaction;

import java.util.List;
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


    public void createNewCustomer(Session connection, Customer customer) {
        CRUD<Customer> insert = new CRUD<>(Customer.class);
         insert.create(connection, customer);

    }

    public void createNewAccount(Session connection, Account account) {
        CRUD<Account> insert = new CRUD<>(Account.class);
         insert.create(connection, account);
    }

    public void createNewBank(Session connection, Bank bank) {
        CRUD<Bank> insert = new CRUD<>(Bank.class);
         insert.create(connection, bank);
    }

    public Customer getCustomerByCustomerNumber(Session connection, Customer customer) {
   /*     SELECT t.*
        FROM Hanieh.Customer t
        WHERE CustomerNumber like '%1'
*/
        String hqlQuery = "SELECT c FROM  Customer c WHERE c.customerNumber LIKE :name";
        Query query = connection.createQuery(hqlQuery);
        query.setParameter("name", customer.getCustomerNumber());
        List<Customer> customers = query.list();
        if (customers.size()==0) {
            return null;
        } else
            return customers.get(0);
    }


    public Branch getBranchByCode(Session connection, Branch branch) {
        String hqlQuery = "SELECT c FROM  Branch c WHERE c.branchCode LIKE :code";
        Query query = connection.createQuery(hqlQuery);
        query.setParameter("code", "%" + branch.getBranchCode() + "%");
        List<Branch> branches = query.list();
        if (branches.size()==0) {
            return null;
        } else
            return branches.get(0);
    }

    public void SaveOrUpdateNewTransaction(Session connection, Transaction transaction) {
        CRUD<Transaction> insert = new CRUD<>(Transaction.class);
        insert.create(connection, transaction);

    }

    public Account getAccountByAccountNumber(Session connection, Account account) {
        String hqlQuery = "SELECT c FROM  Account c WHERE c.AccountNumber LIKE :code";
        Query query = connection.createQuery(hqlQuery);
        query.setParameter("code", "%" + account.getAccountNumber() + "%");
        List<Account> accounts = query.list();
        if (accounts.size()==0) {
            return null;
        } else
            return accounts.get(0);
    }


}
