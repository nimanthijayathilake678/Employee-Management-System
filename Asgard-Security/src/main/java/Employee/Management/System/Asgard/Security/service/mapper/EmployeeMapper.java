package Employee.Management.System.Asgard.Security.service.mapper;

import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;
import Employee.Management.System.Asgard.Security.entity.Employee;


import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeDTO dto) {
        // Map fields from DTO to entity
        if (dto == null) {
            return null;
        }
        return Employee.builder()
                .employee_id(dto.getEmployeeId())
                .employeeCode(dto.getEmployeeCode())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .position(dto.getPosition())
                .hireDate(dto.getHireDate())
                .baseSalary(dto.getBaseSalary())
                .active(dto.isActive())
                .build();
    }

    public EmployeeDTO toDto(Employee entity) {
        // Map fields from entity to DTO
        if (entity == null) {
            return null;
        }

        return EmployeeDTO.builder()
                .employeeId(entity.getEmployee_id())
                .employeeCode(entity.getEmployeeCode())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .position(entity.getPosition())
                .hireDate(entity.getHireDate())
                .baseSalary(entity.getBaseSalary())
                .active(entity.isActive())
                .build();

    }
}
