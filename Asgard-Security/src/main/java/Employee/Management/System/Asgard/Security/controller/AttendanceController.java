package Employee.Management.System.Asgard.Security.controller;

import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import Employee.Management.System.Asgard.Security.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Create a new attendance record
    @PostMapping
    public ResponseEntity<AttendanceDTO> createAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        AttendanceDTO createdAttendance = attendanceService.createAttendance(attendanceDTO);
        return ResponseEntity.ok(createdAttendance);
    }

    // Optionally, you could add more endpoints like getting records, updating, deleting, etc.
}
