package Employee.Management.System.Asgard.Security.entity.dto;

import Employee.Management.System.Asgard.Security.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;
}
