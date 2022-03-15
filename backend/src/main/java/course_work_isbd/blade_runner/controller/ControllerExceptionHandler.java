package course_work_isbd.blade_runner.controller;

import course_work_isbd.blade_runner.dto.responses.ErrorMessagerResponse;
import course_work_isbd.blade_runner.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessagerResponse resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessagerResponse message = new ErrorMessagerResponse();

        message.setStatusCode(HttpStatus.NOT_FOUND.value());
        message.setTimestamp(new Date());
        message.setMessage(ex.getMessage());
        message.setDescription(request.getDescription(false));

        log.warn("There are some troubles with finding resource: {}", message);
        return message;
    }

}
