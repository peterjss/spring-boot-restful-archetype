package ${package}.server.openapi.v1.exception;

public class UserNotFountException extends RuntimeException {
    private Long userId;
    private String username;


    public UserNotFountException(Long userId) {
        this.userId = userId;
    }

    public UserNotFountException(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
