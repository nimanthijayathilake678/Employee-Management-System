package Employee.Management.System.Asgard.Security.service.impl;

import Employee.Management.System.Asgard.Security.entity.Attendance;
import Employee.Management.System.Asgard.Security.entity.Employee;
import Employee.Management.System.Asgard.Security.entity.DutyPoint;
import Employee.Management.System.Asgard.Security.entity.dto.AttendanceDTO;
import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.repository.AttendanceRepository;
import Employee.Management.System.Asgard.Security.repository.EmployeeRepository;
import Employee.Management.System.Asgard.Security.repository.DutyPointRepository;
import Employee.Management.System.Asgard.Security.service.AttendanceService;
import Employee.Management.System.Asgard.Security.service.mapper.AttendanceMapper;
import Employee.Management.System.Asgard.Security.service.validator.AttendanceValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private final AttendanceRepository attendanceRepository;

    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final DutyPointRepository dutyPointRepository;

    private final AttendanceMapper attendanceMapper;
    private final AttendanceValidator attendanceValidator;

    public AttendanceServiceImpl(
            AttendanceRepository repo,
            EmployeeRepository employeeRepo,
            DutyPointRepository dutyPointRepo,
            AttendanceMapper mapper,
            AttendanceValidator validator) {
        this.attendanceRepository = repo;
        this.employeeRepository = employeeRepo;
        this.dutyPointRepository = dutyPointRepo;
        this.attendanceMapper = mapper;
        this.attendanceValidator = validator;
    }

    @Override
    public AttendanceDTO createAttendance(AttendanceDTO dto) {
        attendanceValidator.validateForCreate(dto);

        // Fetch the existing Employee from the database
        System.out.println(dto.getEmployee().getEmployee_id());
        Employee employee = employeeRepository.findById(dto.getEmployee().getEmployee_id())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Fetch the existing DutyPoint from the database (if applicable)
        DutyPoint dutyPoint = dutyPointRepository.findById(dto.getDutyPoint().getDutyPoint_id())
                .orElseThrow(() -> new RuntimeException("DutyPoint not found"));

        // Set the fetched Employee and DutyPoint to the Attendance entity
        Attendance entity = attendanceMapper.toEntity(dto);
        entity.setEmployee(employee); // Set the existing Employee
        entity.setDutyPoint(dutyPoint); // Set the existing DutyPoint

        Attendance saved = attendanceRepository.save(entity);
        return attendanceMapper.toDto(saved);
    }

    @Override
    public List<AttendanceDTO> getAllAttendance() {
        List<Attendance> attendance = attendanceRepository.findAll();
        System.out.println("TEst"+attendance);
        return attendanceMapper.toDtoList(attendance);
    }
}
