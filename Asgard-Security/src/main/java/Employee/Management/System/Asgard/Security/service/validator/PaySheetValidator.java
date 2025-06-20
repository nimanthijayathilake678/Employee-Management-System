package Employee.Management.System.Asgard.Security.service.validator;

import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;
import Employee.Management.System.Asgard.Security.exception.BadRequestException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class PaySheetValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public void validateForCreate(PaysheetDTO paysheetDTO){
        if(paysheetDTO == null){
            throw new BadRequestException("Paysheet data is required");
        }

        validateCommonFields(paysheetDTO);


    }

    public void validateCommonFields(PaysheetDTO paysheetDTO){

    }

}
