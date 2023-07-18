package serviceBussinceManager.AccountingService;


import repository.Repository;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AccountService {
    Repository repository = Repository.INSTANCE;


    public void createSampleAccountForUser() {
        String logTrack = String.valueOf(UUID.randomUUID());
        Account account = new Account();
        account.setTransactions(null);
        Branch branch = new Branch("Jordan");
        if (repository.getBranchByCode(branch, logTrack) == null) {
            System.err.println("branch not found ");
        } else {
            branch = repository.getBranchByCode(branch, logTrack);
            account.setBranch(branch);
            String[] accountNumber = {"1234"};
            String[] customerNumbers = {"11", "2"};
            account.setAccount_number(accountNumber[0]);
            Set<Account> accountSet = new HashSet<Account>();
            for (String customerNumber : customerNumbers) {
                Customer customer = new Customer(customerNumber);
                if (repository.getCustomerByCustomerNumber(customer, logTrack) == null) {
                    account.getCustomers().add(customer);
                    accountSet.add(account);
                    customer.setAccounts(accountSet);
                    customer.setAccounts(accountSet);
                } else {
                    customer = repository.getCustomerByCustomerNumber(customer, logTrack);
                    account.getCustomers().add(customer);
                    accountSet.add(account);
                    customer.setAccounts(accountSet);
                }
                repository.createNewCustomer(customer, logTrack);
                System.out.println("createAccountForUser SUCCESS");

            }



        }
    }
}



