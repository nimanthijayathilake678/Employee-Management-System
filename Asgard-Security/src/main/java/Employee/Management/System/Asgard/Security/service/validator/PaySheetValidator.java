package Employee.Management.System.Asgard.Security.service.validator;

import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;
import Employee.Management.System.Asgard.Security.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Component
public class PaySheetValidator {

    public void validateForCreate(PaysheetDTO paysheetDTO) {
        if (paysheetDTO == null) {
            throw new BadRequestException("Paysheet data is required");
        }

        validateCommonFields(paysheetDTO);

        if (paysheetDTO.getPayPeriodMonth() == null || paysheetDTO.getPayPeriodYear() == null) {
            throw new BadRequestException("Pay period month and year are required");
        }

        if (paysheetDTO.getBaseSalary() == null || paysheetDTO.getBaseSalary().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Base salary must be a positive value");
        }
    }

    public void validateCommonFields(PaysheetDTO paysheetDTO) {
        if (paysheetDTO.getEmployee() == null) {
            throw new BadRequestException("Valid employee is required");
        }

        if (paysheetDTO.getGrossPay() == null || paysheetDTO.getGrossPay().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Gross pay must be a positive value");
        }

        if (paysheetDTO.getNetPay() == null || paysheetDTO.getNetPay().compareTo(BigDecimal.ZERO) < 0) {
            throw new BadRequestException("Net pay must be a positive value");
        }
    }
}
