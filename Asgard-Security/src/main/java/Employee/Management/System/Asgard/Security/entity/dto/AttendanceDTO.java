package Employee.Management.System.Asgard.Security.entity.dto;

import Employee.Management.System.Asgard.Security.entity.DutyPoint;
import Employee.Management.System.Asgard.Security.entity.Employee;
import Employee.Management.System.Asgard.Security.enums.AttendanceStatus;
import Employee.Management.System.Asgard.Security.enums.ShiftType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceDTO {
    private Long attendance_id;
    private Employee employee;
    private LocalDate date;
    private ShiftType shift;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Integer breakDuration;
    private BigDecimal overtimeHours;
    private AttendanceStatus status;
    private DutyPoint dutyPoint;
    private String remarks;
    private LocalDateTime createdAt;
}
