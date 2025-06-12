package Employee.Management.System.Asgard.Security.service.validator;

import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;
import Employee.Management.System.Asgard.Security.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Component
public class EmployeeValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public void validateForCreate(EmployeeDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Employee data is required");
        }

        validateCommonFields(dto);

        if (dto.getHireDate() == null) {
            throw new BadRequestException("Hire date is required");
        }

        if (dto.getHireDate().isAfter(LocalDateTime.now())) {
            throw new BadRequestException("Hire date cannot be in the future");
        }

        if (dto.getBaseSalary() == null || dto.getBaseSalary().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Base salary must be a positive value");
        }
    }

    public void validateForUpdate(EmployeeDTO dto) {
        if (dto == null || dto.getEmployeeId() == null) {
            throw new BadRequestException("Employee ID and data are required for update");
        }

        validateCommonFields(dto);
    }

    private void validateCommonFields(EmployeeDTO dto) {
        if (!StringUtils.hasText(dto.getFirstName())) {
            throw new BadRequestException("First name is required");
        }

        if (!StringUtils.hasText(dto.getLastName())) {
            throw new BadRequestException("Last name is required");
        }

        if (!StringUtils.hasText(dto.getEmail()) || !EMAIL_PATTERN.matcher(dto.getEmail()).matches()) {
            throw new BadRequestException("Valid email is required");
        }

        if (!StringUtils.hasText(dto.getEmployeeCode())) {
            throw new BadRequestException("Employee code is required");
        }
    }
}
