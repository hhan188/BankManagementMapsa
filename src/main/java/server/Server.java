package server;

import serviceBussinceManager.AccountingService.Account;
import serviceBussinceManager.AccountingService.AccountService;
import serviceBussinceManager.BaseBackService.CreatBankData;
import repository.Repository;
import serviceBussinceManager.TransactionManagmentService.TransactionService;

public class Server {

    public static void main(String[] args) throws Exception {
        final Server server = new Server();
        server.initServerComponents();

    }

    private void initServerComponents() throws Exception {

        //todo: logService
        Repository.INSTANCE.init();
        //  CreatBankData.loadData();
        AccountService accountService = new AccountService();
        // accountService.createSampleCustomerForUser();
       // TransactionService transactionService = new TransactionService();
        //transactionService.paymentTransaction(5000000, "11", "1234");
       // Account a = new Account("1234");
        accountService.sampleTestForCatchData("1234");

    }

    private void stop() {
        //todo: logService
        Repository.INSTANCE.stop();


    }

}
