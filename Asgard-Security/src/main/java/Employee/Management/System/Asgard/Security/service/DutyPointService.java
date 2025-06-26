package Employee.Management.System.Asgard.Security.service;

import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;

import java.util.List;

public interface DutyPointService{
    DutyPointDTO createDutyPoint(DutyPointDTO dutyPointDTO);
    List<DutyPointDTO> getAllDutyPoints();
}
