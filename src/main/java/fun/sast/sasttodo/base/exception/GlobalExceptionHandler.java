package fun.sast.sasttodo.base.exception;


import fun.sast.sasttodo.base.response.JsonResult;
import fun.sast.sasttodo.base.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult doHandleServiceException(ServiceException ex) {
        log.error("ServiceException:"+ex.getStatusCode().getMsg());
        return new JsonResult(ex.getStatusCode());
    }

    @ExceptionHandler
    public JsonResult doHandleIllegalArgumentException(IllegalArgumentException ex) {
        String message = ex.getMessage();
        log.error("IllegalArgumentException: " + message);
        return new JsonResult(StatusCode.OPERATION_FAILED, message);
    }
    @ExceptionHandler
    public JsonResult doHandleRuntimeException(RuntimeException ex) {
        String message = ex.getMessage();
        log.error("RuntimeException: " + message);
        return new JsonResult(StatusCode.OPERATION_FAILED, message);
    }

    @ExceptionHandler
    public JsonResult doHandleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getFieldError().getDefaultMessage();
        log.error("MethodArgumentNotValidException: " + message);
        return new JsonResult(StatusCode.VALIDATE_ERROR, message);
    }

    @ExceptionHandler
    public JsonResult doHandleConstraintViolationException(ConstraintViolationException ex) {
        String message = ex.getMessage().split(":")[1].trim();
        log.error("ConstraintViolationException: " + message);
        return new JsonResult(StatusCode.VALIDATE_ERROR, message);
    }

}