package Employee.Management.System.Asgard.Security.controller;

import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;
import Employee.Management.System.Asgard.Security.service.DutyPointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/DutyPoint")
public class DutyPointController {
    private final DutyPointService dutyPointService;

    public DutyPointController (DutyPointService dutyPointService){
        this.dutyPointService=dutyPointService;
    }

    @PostMapping
    public ResponseEntity<DutyPointDTO > createDutyPoint (@RequestBody DutyPointDTO dutyPointDto){
        DutyPointDTO createDutyPoint =dutyPointService.createDutyPoint(dutyPointDto);
        return ResponseEntity.ok(createDutyPoint);
    }
}
