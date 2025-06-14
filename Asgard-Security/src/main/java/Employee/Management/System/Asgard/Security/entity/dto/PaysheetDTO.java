package Employee.Management.System.Asgard.Security.entity.dto;

import Employee.Management.System.Asgard.Security.entity.Employee;
import Employee.Management.System.Asgard.Security.entity.User;
import Employee.Management.System.Asgard.Security.enums.PaysheetStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaysheetDTO {
    private Long paySheet_id;
    private Employee employee;
    private Integer payPeriodMonth; // 1 = January, ..., 12 = December
    private Integer payPeriodYear;
    private BigDecimal baseSalary;
    private BigDecimal overtimePay = BigDecimal.ZERO;
    private BigDecimal bonuses = BigDecimal.ZERO;
    private BigDecimal deductions = BigDecimal.ZERO;
    private BigDecimal grossPay;
    private BigDecimal taxDeductions = BigDecimal.ZERO;
    private BigDecimal netPay;
    private PaysheetStatus status;
    private User createdBy;
    private LocalDateTime createdAt;
}
