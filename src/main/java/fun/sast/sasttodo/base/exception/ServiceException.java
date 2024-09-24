package fun.sast.sasttodo.base.exception;

import fun.sast.sasttodo.base.response.StatusCode;
import lombok.Getter;

public class ServiceException extends RuntimeException{
    @Getter
    private StatusCode statusCode;

    public ServiceException(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
