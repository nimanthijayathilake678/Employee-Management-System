package Employee.Management.System.Asgard.Security.service.impl;

import Employee.Management.System.Asgard.Security.entity.dto.EmployeeDTO;
import Employee.Management.System.Asgard.Security.entity.Employee;
import Employee.Management.System.Asgard.Security.repository.EmployeeRepository;
import Employee.Management.System.Asgard.Security.service.EmployeeService;
import Employee.Management.System.Asgard.Security.service.mapper.EmployeeMapper;
import Employee.Management.System.Asgard.Security.service.validator.EmployeeValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeValidator employeeValidator;

    public EmployeeServiceImpl(EmployeeRepository repo, EmployeeMapper mapper, EmployeeValidator validator) {
        this.employeeRepository = repo;
        this.employeeMapper = mapper;
        this.employeeValidator = validator;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        employeeValidator.validateForCreate(dto);
        Employee entity = employeeMapper.toEntity(dto);
        return employeeMapper.toDto(employeeRepository.save(entity));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDtoList(employees);
    }




}
