/*
 * Copyright (c) 2018. For DMSoft Group.
 */

package ${package}.server.service;

import ${package}.server.dto.UserDto;

import java.util.List;

/**
 * Created by Peter on 2016/7/11.
 */
public interface UserService {

    /**
     * Find user information by code.
     *
     * @param code code
     * @return UserDto
     */
    UserDto findUserByCode(String code);

    /**
     * Find user information by id.
     *
     * @param id id
     * @return UserDto
     */
    UserDto findUserById(Long id);

    /**
     * Find user by login name.
     *
     * @param loginName login name.
     * @return User.
     */
    UserDto findByLoginName(String loginName);

    /**
     * Find users by phone.
     *
     * @param phone phone.
     * @return Users.
     */
    List<UserDto> findAllByPhone(String phone);

    /**
     * Find users by email.
     *
     * @param email email.
     * @return Users.
     */
    List<UserDto> findAllByEmail(String email);

    /**
     * Find users by name.
     *
     * @param name name.
     * @return Users.
     */
    List<UserDto> findAllByName(String name);

    /**
     * Find all users.
     *
     * @return List UserDto
     */
    List<UserDto> findAll();

    /**
     * Validate if login information is legal.
     *
     * @param userName name of user
     * @param password password of user
     * @return if legal return corresponding userDto, else return null
     */
    UserDto validateUser(String userName, String password);

    /**
     * Change password for user.
     *
     * @param userName name of user
     * @param oldPwd   the old password
     * @param newPwd   the new password
     */
    boolean changePassword(String userName, String oldPwd, String newPwd,String confirmPwd);

    /**
     * 插入数据库
     *
     * @param userDto
     * @return
     */
    void saveUser(UserDto userDto);

    /**
     * 删除用户
     *
     * @param code
     * @return
     */
    void deleteByCode(String code);

    /**
     * 修改数据库
     *
     * @param userDto
     * @return boolean
     */
    boolean updateByCode(UserDto userDto);

    /**
     * 重置密码
     *
     * reset passowrd
     * **/
    void resetPassword(String code);

}
