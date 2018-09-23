package ${package}.server.openapi;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int status;

    // is success
    private boolean success = true;

    //data: { key1: value1, ... }
    private T data;

    public ResponseEntity(boolean success) {
        this.success = success;
    }

    public ResponseEntity(T data) {
        this.data = data;
    }

    public ResponseEntity(int status) {
        this.status = status;
    }

    public ResponseEntity(T data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
    }

    public static ResponseEntity ofFailed() {
        return new ResponseEntity(false);
    }

    public static ResponseEntity ofSuccess() {
        return new ResponseEntity(true);
    }

    public ResponseEntity success(boolean success) {
        this.setSuccess(success);
        return this;
    }

    public ResponseEntity data(T data) {
        this.setData(data);
        return this;
    }

    public ResponseEntity status(HttpStatus status) {
        this.setStatus(status.value());
        return this;
    }
}
