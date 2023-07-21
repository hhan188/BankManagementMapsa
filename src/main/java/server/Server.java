package server;

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
        // AccountService accountService = new AccountService();
        // accountService.createSampleCustomerForUser();
        TransactionService transactionService = new TransactionService();
        transactionService.paymentTransaction(5000000, "11", "1234");

    }

    private void stop() {
        //todo: logService
        Repository.INSTANCE.stop();


    }

}
