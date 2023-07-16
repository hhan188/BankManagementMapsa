package Exception;


public class BusinessException extends Exception {
    private final businessResponseStatus status;


    public BusinessException(BusinessException.businessResponseStatus status) {
        this.status = status;
    }


    public enum businessResponseStatus {
        SUCCESS(0),
        FAILED(1000),
        UNKNOWN(1201),
        ;
        private final int value;

        businessResponseStatus(int value) {
            this.value = value;
        }

    }
}
