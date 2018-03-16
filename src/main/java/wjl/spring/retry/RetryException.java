package wjl.spring.retry;

import lombok.Data;

@Data
public class RetryException extends RuntimeException {
    private String code;
    private String message;

    public RetryException() {

    }

    public RetryException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}