package Employee.Management.System.Asgard.Security.controller;

import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
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

    //get all the attendace
    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> getAllAttendance() {
        List<AttendanceDTO> attendance = attendanceService.getAllAttendance();
        return ResponseEntity.ok(attendance);
    }

    //get attendance when employee id is given
    @GetMapping("/{id}")
    public ResponseEntity<List<AttendanceDTO>> getAttendanceByEmployeeId(@PathVariable Long id){
        List<AttendanceDTO> attendance=attendanceService.fetchAttendanceByEmployeeId(id);
        return ResponseEntity.ok(attendance);
    }
}
