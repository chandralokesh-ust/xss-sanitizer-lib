package xss.sanitizer.lib.exception;

public class XSSViolationException extends RuntimeException {

    public XSSViolationException(String message) {
        super(message);
    }
}