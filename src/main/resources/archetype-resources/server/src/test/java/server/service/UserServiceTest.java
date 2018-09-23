package ${package}.server.service;

import ${package}.server.AppServerApplication;
import ${package}.server.dao.UserDao;
import ${package}.server.dto.UserDto;
import ${package}.server.entity.User;
import ${package}.server.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppServerApplication.class)
@TestExecutionListeners
public class UserServiceTest {

    private UserService userService;
    @Mock
    private UserDao spyUserDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        spyUserDao = Mockito.mock(UserDao.class);
        userService = new UserServiceImpl();
        ReflectionTestUtils.setField(userService, "userDao", spyUserDao);
    }

    @Test
    public void findById() {
        User user = new User();
        user.setId(1L);
        user.setLoginName("admin");
        Mockito.when(spyUserDao.findById(1L)).thenReturn(java.util.Optional.ofNullable(user));

        UserDto entity = userService.findUserById(1L);
        assertThat(entity.getLoginName()).isEqualTo("admin");
		assertThat(users.get(0).getLoginName()).isEqualTo("admin");
    }
}
