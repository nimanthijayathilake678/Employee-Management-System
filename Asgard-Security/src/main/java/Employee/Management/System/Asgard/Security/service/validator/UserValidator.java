package Employee.Management.System.Asgard.Security.service.validator;

import Employee.Management.System.Asgard.Security.entity.dto.UserDTO; // Assuming there is a UserDTO class
import Employee.Management.System.Asgard.Security.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Component
public class UserValidator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public void validateForCreate(UserDTO dto) {
        if (dto == null) {
            throw new BadRequestException("User  data is required");
        }

        validateCommonFields(dto);

        if (!StringUtils.hasText(dto.getPassword())) {
            throw new BadRequestException("Password is required");
        }
    }

    public void validateForUpdate(UserDTO dto) {
        if (dto == null || dto.getId() == null) {
            throw new BadRequestException("User  ID and data are required for update");
        }
        validateCommonFields(dto);
    }

    private void validateCommonFields(UserDTO dto) {
        if (!StringUtils.hasText(dto.getUsername())) {
            throw new BadRequestException("Username is required");
        }

        if (!StringUtils.hasText(dto.getEmail()) || !EMAIL_PATTERN.matcher(dto.getEmail()).matches()) {
            throw new BadRequestException("Valid email is required");
        }
    }
}
