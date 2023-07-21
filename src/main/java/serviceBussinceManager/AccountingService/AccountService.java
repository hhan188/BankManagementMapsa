package serviceBussinceManager.AccountingService;


import repository.Repository;
import serviceBussinceManager.BaseBackService.Branch;
import serviceBussinceManager.CustomerService.Customer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AccountService {
    Repository repository = Repository.INSTANCE;

    public void createSampleCustomerForUser() {
        String logTrack = String.valueOf(UUID.randomUUID());
        Account account = new Account();
        //todo : set transaction in constructor null
        account.setTransactions(null);
        account.setBalance(2000000);
        Branch branch = new Branch("Jordan");
        branch = repository.getBranchByCode(branch, logTrack);
        if (branch == null) {
            System.err.println("branch not found ");
            return;
        } else {
            account.setBranch(branch);
            String[] accountNumber = {"1234"};
            String[] customerNumbers = {"11", "2"};
            account.setAccountNumber(accountNumber[0]);
            Set<Account> accountSet = new HashSet<Account>();
            for (String customerNumber : customerNumbers) {
                Customer customer = new Customer(customerNumber);
                if (repository.getCustomerByCustomerNumber(customer, logTrack) == null) {
                    account.getCustomers().add(customer);
                    accountSet.add(account);
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



