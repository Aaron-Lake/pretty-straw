package cn.tedu.straw.api.user.ex;

public class ClassDisableException extends ServiceException {

    public ClassDisableException() {
    }

    public ClassDisableException(String message) {
        super(message);
    }

    public ClassDisableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassDisableException(Throwable cause) {
        super(cause);
    }

    public ClassDisableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
