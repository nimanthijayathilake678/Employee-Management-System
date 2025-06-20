package Employee.Management.System.Asgard.Security.service.impl;

import Employee.Management.System.Asgard.Security.entity.Attendance;
import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import Employee.Management.System.Asgard.Security.repository.AttendanceRepository;
import Employee.Management.System.Asgard.Security.service.AttendanceService;
import Employee.Management.System.Asgard.Security.service.mapper.AttendanceMapper;
import Employee.Management.System.Asgard.Security.service.validator.AttendanceValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;
    private final AttendanceValidator attendanceValidator;

    public AttendanceServiceImpl(
            AttendanceRepository repo,
            AttendanceMapper mapper,
            AttendanceValidator validator) {
        this.attendanceRepository = repo;
        this.attendanceMapper = mapper;
        this.attendanceValidator = validator;
    }

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO dto) {
        attendanceValidator.validateForCreate(dto);

        Attendance entity = attendanceMapper.toEntity(dto);
        Attendance saved = attendanceRepository.save(entity);

        return attendanceMapper.toDto(saved);
    }
}
