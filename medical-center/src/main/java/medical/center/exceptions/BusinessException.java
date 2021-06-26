package medical.center.exceptions;

public class BusinessException extends Exception {

    private static final long serialVersionUID = -6633585006375533566L;

    public BusinessException(final String message) {
        super(message);
    }

}

