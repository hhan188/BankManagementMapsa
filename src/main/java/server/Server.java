package server;

import serviceBussinceManager.AccountingService.AccountService;
import serviceBussinceManager.BaseBackService.CreatBankData;
import repository.Repository;

public class Server {

    public static void main(String[] args) throws Exception {
        final Server server = new Server();
        server.initServerComponents();

    }

    private void initServerComponents() throws Exception {

        //todo: logService
        Repository.INSTANCE.init();
        CreatBankData.loadData();
        AccountService accountService = new AccountService();
        accountService.createSampleAccountForUser();

    }

    private void stop() {
        //todo: logService
        Repository.INSTANCE.stop();


    }

}
