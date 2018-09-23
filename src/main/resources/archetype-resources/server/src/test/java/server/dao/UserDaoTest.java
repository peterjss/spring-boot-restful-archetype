package ${package}.server.dao;

import ${package}.server.AppServerApplication;
import ${package}.server.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
@DirtiesContext
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findByUserId() {
        Page<User> usersPage = userDao.findAll(PageRequest.of(1, 20));
        List<User> users = usersPage.getContent();

        assertThat(users).hasSize(2);
    }
}