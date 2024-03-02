package com.up.real.estate.agent.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DefaultHandlerException extends RuntimeException {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private StackTraceElement[] stackTrace;
    private String localizedMessage;

    public DefaultHandlerException() {
        this.timestamp = LocalDateTime.now();
    }

    public DefaultHandlerException(HttpStatus status, Throwable ex) {
        this();
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = ex.getLocalizedMessage().substring(0, ex.getLocalizedMessage().indexOf(":"));
        this.stackTrace = null;
        this.localizedMessage = null;
    }
}
