package Employee.Management.System.Asgard.Security.service.mapper;

import Employee.Management.System.Asgard.Security.entity.Employee;
import Employee.Management.System.Asgard.Security.entity.Paysheet;
import Employee.Management.System.Asgard.Security.entity.User;
import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;
import Employee.Management.System.Asgard.Security.enums.PaysheetStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaySheetMapper {
    public Paysheet toEntity(PaysheetDTO paysheetDTO){
        //map the feilds to the entity
        if (paysheetDTO ==null){
            return null;
        }
        return Paysheet.builder()
                .paySheet_id(paysheetDTO.getPaySheet_id())
                .employee(paysheetDTO.getEmployee())
                .payPeriodMonth(paysheetDTO.getPayPeriodMonth())
                .baseSalary(paysheetDTO.getBaseSalary())
                .overtimePay(paysheetDTO.getOvertimePay())
                .bonuses(paysheetDTO.getBonuses())
                .deductions(paysheetDTO.getDeductions())
                .grossPay(paysheetDTO.getGrossPay())
                .taxDeductions(paysheetDTO.getTaxDeductions())
                .netPay(paysheetDTO.getNetPay())
                .status(paysheetDTO.getStatus()).build();
    }
}
