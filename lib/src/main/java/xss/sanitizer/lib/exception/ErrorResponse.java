package xss.sanitizer.lib.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String timestamp;
    private Integer code;
    private String message;
    private StackTraceElement[] stackTrace;
}

