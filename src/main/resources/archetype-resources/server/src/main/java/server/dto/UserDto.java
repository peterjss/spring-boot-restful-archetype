package ${package}.server.dto;

import lombok.Data;

/**
 * Created by Peter Li on 2016/7/25.
 */
@Data
public class UserDto {

    private Long id;
    private String code;
    private String name;
    private String loginName;
    private String password;
    private String email;
    private String phone;
    private String createTime;
    private String lastestLogin;
}
