package blog.execption;

public class PostNotFoundExecption extends Exception{
    public PostNotFoundExecption() {
    }

    public PostNotFoundExecption(String message) {
        super(message);
    }

    public PostNotFoundExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFoundExecption(Throwable cause) {
        super(cause);
    }

    public PostNotFoundExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
