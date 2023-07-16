package server;

import serviceBussinceManager.BaseBackService.CreatBankData;
import repository.Repository;
import services.LogService;

public class Server {

    public static void main(String[] args) throws Exception {
        final Server server = new Server();
        server.initServerComponents();

    }
    private void initServerComponents() throws Exception{

        Repository.INSTANCE.init();
      //  LogService.INSTANCE.init();
     //   CreatBankData.loadData();

    }

    private void stop() {

        Repository.INSTANCE.stop();
      //  LogService.INSTANCE.stop();

    }

}
