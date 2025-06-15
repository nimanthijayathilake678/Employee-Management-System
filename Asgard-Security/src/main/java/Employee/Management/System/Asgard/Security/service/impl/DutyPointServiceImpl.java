package Employee.Management.System.Asgard.Security.service.impl;

import Employee.Management.System.Asgard.Security.entity.DutyPoint;
import Employee.Management.System.Asgard.Security.entity.dto.DutyPointDTO;
import Employee.Management.System.Asgard.Security.repository.DutyPointRepository;
import Employee.Management.System.Asgard.Security.service.DutyPointService;
import Employee.Management.System.Asgard.Security.service.mapper.DutyPointMapper;
import Employee.Management.System.Asgard.Security.service.validator.DutyPointValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DutyPointServiceImpl implements DutyPointService {

    @Autowired
    private final DutyPointRepository dutyPointRepository;
    private final DutyPointMapper dutyPointMapper;
    private final DutyPointValidator dutyPointValidator;

    public DutyPointServiceImpl(DutyPointRepository repo, DutyPointMapper mapper, DutyPointValidator validator) {
            this.dutyPointRepository = repo;
            this.dutyPointMapper = mapper;
            this.dutyPointValidator = validator;
        }

        @Override
        public DutyPointDTO createDutyPoint(DutyPointDTO dto) {
            dutyPointValidator.validateForCreate(dto);

            DutyPoint entity = dutyPointMapper.toEntity(dto);
            DutyPoint saved = dutyPointRepository.save(entity);

            return dutyPointMapper.toDto(saved);
        }
    }
