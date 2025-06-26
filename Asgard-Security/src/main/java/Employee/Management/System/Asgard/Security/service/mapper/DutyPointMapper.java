package Employee.Management.System.Asgard.Security.service.mapper;

import Employee.Management.System.Asgard.Security.entity.DutyPoint;
import Employee.Management.System.Asgard.Security.entity.Employee;
import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DutyPointMapper {

    public DutyPoint toEntity(DutyPointDTO dto) {
        if (dto == null) {
            return null;
        }
        return DutyPoint.builder()
                .dutyPoint_id(dto.getDutyPoint_id())
                .dutyPoint_name(dto.getDutyPoint_name())
                .phone(dto.getPhone())
                .dutyPoint_location(dto.getDutyPoint_location())
                .dutyPointCharges(dto.getDutyPointCharges())
                .build();
    }

    public DutyPointDTO toDto(DutyPoint entity) {
        if (entity == null) {
            return null;
        }
        return DutyPointDTO.builder()
                .dutyPoint_id(entity.getDutyPoint_id())
                .dutyPoint_name(entity.getDutyPoint_name())
                .phone(entity.getPhone())
                .dutyPoint_location(entity.getDutyPoint_location())
                .dutyPointCharges(entity.getDutyPointCharges())
                .build();
    }

    public List<DutyPointDTO> toDtoList(List<DutyPoint> dutyPoints) {
        if (dutyPoints == null) {
            return null;
        }
        return dutyPoints.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
