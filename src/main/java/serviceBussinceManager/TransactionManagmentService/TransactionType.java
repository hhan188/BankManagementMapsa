package serviceBussinceManager.TransactionManagmentService;

public enum TransactionType {

    payment(0, "paymentTransaction"),
    Refund(1,"RefundTransaction"),
    deposit(2,"DepositTransaction");

    private final int code;
    private final String description;

    TransactionType(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
