package Employee.Management.System.Asgard.Security.entity;

import Employee.Management.System.Asgard.Security.enums.PaysheetStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Paysheets", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_id", "pay_period_month", "pay_period_year"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paysheet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paySheet_id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "pay_period_month", nullable = false)
    private Integer payPeriodMonth; // 1 = January, ..., 12 = December

    @Column(name = "pay_period_year", nullable = false)
    private Integer payPeriodYear;

    @Column(name = "base_salary", nullable = false)
    private BigDecimal baseSalary;

    @Column(name = "overtime_pay", nullable = false)
    private BigDecimal overtimePay = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal bonuses = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal deductions = BigDecimal.ZERO;

    @Column(name = "gross_pay", nullable = false)
    private BigDecimal grossPay;

    @Column(name = "tax_deductions", nullable = false)
    private BigDecimal taxDeductions = BigDecimal.ZERO;

    @Column(name = "net_pay", nullable = false)
    private BigDecimal netPay;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaysheetStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
