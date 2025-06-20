package Employee.Management.System.Asgard.Security.service.mapper;

import Employee.Management.System.Asgard.Security.entity.Attendance;
import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {

    public Attendance toEntity(AttendanceDTO dto) {
        if (dto == null) {
            return null;
        }

        return Attendance.builder()
                .attendance_id(dto.getAttendance_id())
                .employee(dto.getEmployee())
                .date(dto.getDate())
                .shift(dto.getShift())
                .checkInTime(dto.getCheckInTime())
                .checkOutTime(dto.getCheckOutTime())
                .breakDuration(dto.getBreakDuration())
                .overtimeHours(dto.getOvertimeHours())
                .status(dto.getStatus())
                .dutyPoint(dto.getDutyPoint())
                .remarks(dto.getRemarks())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public AttendanceDTO toDto(Attendance entity) {
        if (entity == null) {
            return null;
        }

        AttendanceDTO dto = new AttendanceDTO();
        dto.setAttendance_id(entity.getAttendance_id());
        dto.setEmployee(entity.getEmployee());
        dto.setDate(entity.getDate());
        dto.setShift(entity.getShift());
        dto.setCheckInTime(entity.getCheckInTime());
        dto.setCheckOutTime(entity.getCheckOutTime());
        dto.setBreakDuration(entity.getBreakDuration());
        dto.setOvertimeHours(entity.getOvertimeHours());
        dto.setStatus(entity.getStatus());
        dto.setDutyPoint(entity.getDutyPoint());
        dto.setRemarks(entity.getRemarks());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }
}
