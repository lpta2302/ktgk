package bit.ueh.user_service.controller;

import bit.ueh.user_service.DTO.UserRequestDTO;
import bit.ueh.user_service.entity.User;
import bit.ueh.user_service.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userRequest) {
        User newUser = userService.createUser(userRequest);
        return ResponseEntity.ok(newUser);
    }
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(
            userService.findAllUsers()
        );
    }
    @GetMapping("{userId}")
    public ResponseEntity<User> findAllUsers(
        int userId
    ) {
        return ResponseEntity.ok(
            userService.findUserById(userId)
        );
    }
}