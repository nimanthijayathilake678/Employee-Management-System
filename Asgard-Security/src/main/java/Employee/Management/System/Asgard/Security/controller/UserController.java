package Employee.Management.System.Asgard.Security.controller;

import Employee.Management.System.Asgard.Security.entity.dto.UserDTO;
import Employee.Management.System.Asgard.Security.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user record
    @PostMapping
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO userDTO) {
        UserDTO createdUser  = userService.createUser (userDTO);
        return ResponseEntity.ok(createdUser );
    }
}
