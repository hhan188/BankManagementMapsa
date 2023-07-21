package serviceBussinceManager.TransactionManagmentService;

import repository.Repository;
import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.CustomerService.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TransactionService {
    Repository repository = Repository.INSTANCE;

    public void paymentTransaction(long amount, String customerNumber, String AccountNumber) {
        String logTrack = String.valueOf(UUID.randomUUID());

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.payment);
        transaction.setStatus(Status.Inprogress);
        transaction.setInsertdate(new Date());
        transaction.setAmount(amount);
        repository.SaveOrUpdateNewTransaction(transaction,logTrack);
        Customer customer = new Customer(customerNumber);
        Account account = new Account(AccountNumber);
        if (repository.getCustomerByCustomerNumber(customer, logTrack) != null ||
                repository.getAccountByaccountNumber(account, logTrack) != null) {
            /*customer = repository.getCustomerByCustomerNumber(customer, logTrack);*/
            account = repository.getAccountByaccountNumber(account, logTrack);
            if (account.getBalance() > amount) {
                transaction.setStatus(Status.Success);
                transaction.setRrn("123456");
                transaction.setUpdatedate(new Date());
                transaction.setLogResponse("موفق");
                long remain = account.getBalance() - amount;
                account.setBalance(remain);
                List<Transaction> transactionList = new ArrayList<>();
                transactionList.add(transaction);
                account.setTransactions(transactionList);
                transaction.setAccount(account);
                transaction.setAmount(amount);

                repository.SaveOrUpdateNewTransaction(transaction, logTrack);
            } else {
                System.err.println("balance is low!");
                transaction.setLogResponse("ناموفق");
                transaction.setStatus(Status.Fail);
                repository.SaveOrUpdateNewTransaction(transaction, logTrack);
            }

        } else {
            System.err.println("customer not found");
            transaction.setLogResponse("ناموفق");
            transaction.setStatus(Status.Fail);
            repository.SaveOrUpdateNewTransaction(transaction, logTrack);
        }


    }
}
