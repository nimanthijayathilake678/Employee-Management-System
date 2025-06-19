package Employee.Management.System.Asgard.Security.controller;

import Employee.Management.System.Asgard.Security.service.DutyPointService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/DutyPoint")
public class DutyPointController {
    private final DutyPointService dutyPointService;

    public DutyPointController (DutyPointService dutyPointService){
        this.dutyPointService=dutyPointService;
    }
}
