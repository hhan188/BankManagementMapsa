package repository;


import org.hibernate.query.Query;
import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.BaseBackService.Bank;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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

        String hqlQuery = "SELECT c FROM  Customer c WHERE c.customerNumber LIKE :name";
        Query query = connection.createQuery(hqlQuery);
        query.setParameter("name", "%" + customer.getCustomerNumber() + "%");
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
}
