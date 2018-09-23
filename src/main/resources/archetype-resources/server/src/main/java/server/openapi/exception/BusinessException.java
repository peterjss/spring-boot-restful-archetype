package ${package}.server.openapi.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code = 500;
    private String message;

    public  BusinessException(int code, String msg) {
        this.code = code;
        this.message = msg;
    }


}
