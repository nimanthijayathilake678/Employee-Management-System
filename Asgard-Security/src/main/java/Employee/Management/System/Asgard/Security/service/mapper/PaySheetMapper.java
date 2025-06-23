package Employee.Management.System.Asgard.Security.service.mapper;

import Employee.Management.System.Asgard.Security.entity.Paysheet;
import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;
import org.springframework.stereotype.Component;

@Component
public class PaySheetMapper {
    public Paysheet toEntity(PaysheetDTO paysheetDTO){
        //map the fields to the entity
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

    // map entity to the dto
    public PaysheetDTO toDTO(Paysheet paysheet){
        if (paysheet == null){
            return null;
        }
        return PaysheetDTO.builder()
                .paySheet_id(paysheet.getPaySheet_id())
                .employee(paysheet.getEmployee())
                .payPeriodMonth(paysheet.getPayPeriodMonth())
                .baseSalary(paysheet.getBaseSalary())
                .overtimePay(paysheet.getOvertimePay())
                .bonuses(paysheet.getBonuses())
                .deductions(paysheet.getDeductions())
                .grossPay(paysheet.getGrossPay())
                .taxDeductions(paysheet.getTaxDeductions())
                .netPay(paysheet.getNetPay())
                .status(paysheet.getStatus()).build();

    }
}
