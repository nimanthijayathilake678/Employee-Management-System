package Employee.Management.System.Asgard.Security.service;

import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;

import java.util.List;

public interface AttendanceService {
    AttendanceDTO createAttendance(AttendanceDTO attendanceDTO);
    List<AttendanceDTO> getAllAttendance();
    List<AttendanceDTO> fetchAttendanceByEmployeeId(Long employeeId);
}
