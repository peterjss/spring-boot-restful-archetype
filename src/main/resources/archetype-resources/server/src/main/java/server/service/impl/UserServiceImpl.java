/*
 * Copyright (c) 2018. For DMSoft Group.
 */

package $

{package}.server.service.impl;

import ${package}.server.dao.UserDao;
import ${package}.server.dto.UserDto;
import ${package}.server.entity.User;
import ${package}.server.service.UserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto findUserByCode(String code) {
        User user = userDao.findUserByCode(code);
        UserDto dto = new UserDto();

        BeanUtils.copyProperties(user, dto);

        return dto;
    }

    @Override
    public UserDto findByLoginName(String loginName) {
        User user = userDao.findByLoginName(loginName);
        UserDto dto = new UserDto();

        BeanUtils.copyProperties(user, dto);

        return dto;
    }

    @Override
    public UserDto findUserById(Long id) {
        Optional<User> user = userDao.findById(id);
        UserDto dto = new UserDto();

        BeanUtils.copyProperties(user.orElse(null), dto);

        return dto;
    }

    @Override
    public List<UserDto> findAllByPhone(String phone) {
        List<User> entityList = userDao.findAllByPhone(phone);
        List<UserDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public List<UserDto> findAllByEmail(String email) {
        List<User> entityList = userDao.findAllByEmail(email);
        List<UserDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public List<UserDto> findAllByName(String name) {
        List<User> entityList = userDao.findAllByName(name);
        List<UserDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public List<UserDto> findAll() {
        Iterable<User> entityList = userDao.findAll();
        List<UserDto> list = Lists.newArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
            Date date1 = new Date(Long.parseLong(dto.getCreateTime()));
            String qq = simpleDateFormat.format(date1);
            dto.setCreateTime(qq);
        });
        return list;
    }


    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        if (findByLoginName(user.getLoginName()) == null) {
            String createTime = String.valueOf(new Date().getTime());
            user.setCreateTime(createTime);
            String latestLogin = String.valueOf(new Date().getTime());
            user.setLatestLogin(latestLogin);
            user.setPassword("123456");
            String filename = RandomStringUtils.randomAlphanumeric(10);
            user.setCode(filename);
            userDao.save(user);
        } else {
            System.out.println("Login name already exists!");
        }
    }

    @Override
    public void deleteByCode(String code) {
        if (findUserByCode(code) != null) {
            userDao.deleteByCode(code);
        } else {
            System.out.println("there is no date");
        }
    }

    @Override
    public boolean updateByCode(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User newuser = userDao.findUserByCode(user.getCode());
        if (newuser != null) {
            user.setId(newuser.getId());
            userDao.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDto validateUser(String userName, String password) {
        User user = userDao.findByLoginNameAndPassword(userName, password);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @Override
    public boolean changePassword(String userName, String oldPwd, String newPwd, String confirmPwd) {
        User user = userDao.findByLoginName(userName);
        System.out.println(user);
        if (user != null) {
            if (oldPwd.equals(user.getPassword())) {
                if (!confirmPwd.equals(newPwd)) {
                    return false;
                } else {
                    userDao.update(userName, newPwd);
                    System.out.println(true);
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void resetPassword(String code) {
        User user = userDao.findUserByCode(code);
        if (user != null) {
            userDao.update(user.getLoginName(), "123456");
        }
    }
}
