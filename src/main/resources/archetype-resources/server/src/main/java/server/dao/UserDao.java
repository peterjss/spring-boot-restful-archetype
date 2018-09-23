package ${package}.server.dao;

import ${package}.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Created by Peter on 2016/7/11.
 */

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * Find user by code.
     *
     * @param code code.
     * @return User.
     */
    User findUserByCode(String code);

    /**
     * Find user by id.
     *
     * @param id id.
     * @return User.
     */

    Optional<User> findById(Long id);

    /**
     * Find users by phone.
     *
     * @param phone phone.
     * @return Users.
     */
    List<User> findAllByPhone(String phone);

    /**
     * Find users by email.
     *
     * @param email email.
     * @return Users.
     */
    List<User> findAllByEmail(String email);

    /**
     * Find users by name.
     *
     * @param name name.
     * @return Users.
     */
    List<User> findAllByName(String name);

    /**
     * 删除单个用户
     *
     * @param code
     * @return
     */
    //Integer removeUserByCode(String code);
    @Transactional
    void deleteByCode(String code);
   /*
     * Find user by login name.
     *
     * @param loginName login name.
     * @return User.
     */

    User findByLoginName(String loginName);

    /**
     * find user by loginName and password
     *
     * @param loginName loginName
     * @param password  password
     * @return a user
     */
    User findByLoginNameAndPassword(String loginName, String password);

    @Modifying
    @Transactional
    @Query("update User user set user.password = ?2 where user.loginName = ?1")
    void update(String userName, String newPwd);


}
