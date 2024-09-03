package az.ingress.exception;

import az.ingress.model.consrants.ExceptionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static az.ingress.model.consrants.ExceptionConstants.PRODUCT_NOT_FOUND;
import static az.ingress.model.consrants.ExceptionConstants.UNEXPECTED_EXCEPTION;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handle(Exception ex)
    {
        log.error("ActionLog.handle.error", ex);
        return new ErrorResponse(UNEXPECTED_EXCEPTION.getMessage(), UNEXPECTED_EXCEPTION.getCode());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handle(NotFoundException ex){
        log.error("ActionLog.handle.error", ex);
        return new ErrorResponse(ex.getMessage(), ex.getCode());
    }
}
