/*
 * Copyright (c) 2018. For DMSoft Group.
 */

package ${package}.server.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Peter on 2016/7/11.
 */
@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String loginName;
    private String password;
    private String email;
    private String phone;
    private String createTime;
    private String latestLogin;
}
