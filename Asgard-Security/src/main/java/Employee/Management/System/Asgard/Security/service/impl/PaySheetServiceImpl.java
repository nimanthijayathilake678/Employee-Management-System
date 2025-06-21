package Employee.Management.System.Asgard.Security.service.impl;

import Employee.Management.System.Asgard.Security.entity.dto.PaysheetDTO;
import Employee.Management.System.Asgard.Security.entity.Paysheet;
import Employee.Management.System.Asgard.Security.service.PaySheetService;
import Employee.Management.System.Asgard.Security.repository.PaySheetRepository;
import Employee.Management.System.Asgard.Security.service.mapper.PaySheetMapper;
import Employee.Management.System.Asgard.Security.service.validator.PaySheetValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaySheetServiceImpl implements PaySheetService {

    @Autowired
    private final PaySheetRepository paysheetRepository;
    private final PaySheetMapper paysheetMapper;
    private final PaySheetValidator paysheetValidator;

    public PaySheetServiceImpl(PaySheetRepository repository, PaySheetMapper mapper, PaySheetValidator validator) {
        this.paysheetRepository = repository;
        this.paysheetMapper = mapper;
        this.paysheetValidator = validator;
    }

    @Override
    public PaysheetDTO createPaySheet(PaysheetDTO paysheetDTO) {
        paysheetValidator.validateForCreate(paysheetDTO);
        Paysheet entity = paysheetMapper.toEntity(paysheetDTO);
        return paysheetMapper.toDTO(paysheetRepository.save(entity));
    }
}

