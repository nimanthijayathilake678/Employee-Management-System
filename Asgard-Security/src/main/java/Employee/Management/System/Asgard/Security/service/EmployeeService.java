package Employee.Management.System.Asgard.Security.service;

import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
}
