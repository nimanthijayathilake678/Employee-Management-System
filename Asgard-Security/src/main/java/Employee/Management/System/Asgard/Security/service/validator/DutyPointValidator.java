package Employee.Management.System.Asgard.Security.service.validator;

import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Component
public class DutyPointValidator {

    /** phone pattern: +CCCXXXXXXXXX or local 7‑15 digits */
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^(\\+\\d{1,3}[- ]?)?\\d{7,15}$");

    /**
     * Validate data required when a new duty‑point record is created.
     */
    public void validateForCreate(DutyPointDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Duty‑point data is required");
        }

        validateCommonFields(dto);

        if (dto.getDutyPointCharges() == null ||
                dto.getDutyPointCharges().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Duty‑point charges must be a positive value");
        }
    }

    /**
     * Validate when an existing duty‑point record is updated.
     */
    public void validateForUpdate(DutyPointDTO dto) {
        if (dto == null || dto.getDutyPoint_id() == null) {
            throw new BadRequestException("Duty‑point ID and data are required for update");
        }

        validateCommonFields(dto);

        // Charges are optional on update, but if provided they must still be positive
        if (dto.getDutyPointCharges() != null &&
                dto.getDutyPointCharges().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Duty‑point charges must be a positive value");
        }
    }

    /**
     * Shared validation logic
     */
    private void validateCommonFields(DutyPointDTO dto) {
        if (!StringUtils.hasText(dto.getDutyPoint_name())) {
            throw new BadRequestException("Duty‑point name is required");
        }

        if (!StringUtils.hasText(dto.getDutyPoint_location())) {
            throw new BadRequestException("Duty‑point location is required");
        }

        if (StringUtils.hasText(dto.getPhone()) &&
                !PHONE_PATTERN.matcher(dto.getPhone()).matches()) {
            throw new BadRequestException("Phone number is invalid");
        }
    }
}
