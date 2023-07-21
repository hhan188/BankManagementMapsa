package serviceBussinceManager.TransactionManagmentService;

public enum Status {
    Inprogress(0),
    Success(1),
    Fail(2);
    int code;

    Status(int code) {
        this.code = code;
    }
}
