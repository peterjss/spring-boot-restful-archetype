package ${package}.server.openapi.v1;


import ${package}.server.dto.UserDto;
import ${package}.server.openapi.ApiError;
import ${package}.server.openapi.ResponseEntity;
import ${package}.server.openapi.exception.BusinessException;
import ${package}.server.openapi.v1.exception.UserNotFountException;
import ${package}.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserFacade {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<UserDto> findList() {
        List<UserDto> list = userService.findAll();
        return list;
    }

    @PostMapping(value = "")
    public void saveUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        userService.saveUser(userDto);
    }

    @DeleteMapping(value = "/{code}")
    public void delete(@PathVariable("code") String code) {
        userService.deleteByCode(code);
    }

    @ExceptionHandler(UserNotFountException.class)
    public ResponseEntity<ApiError> UserNotFound(UserNotFountException e) {
        Long userId = e.getUserId();

        ApiError error = new ApiError(4, "User [" + userId + "] not found");
        return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    }

}
