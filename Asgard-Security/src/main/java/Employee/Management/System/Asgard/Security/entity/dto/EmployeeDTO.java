package Employee.Management.System.Asgard.Security.entity.dto;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long employeeId;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private LocalDateTime hireDate;
    private BigDecimal baseSalary;
    private boolean active;
}
