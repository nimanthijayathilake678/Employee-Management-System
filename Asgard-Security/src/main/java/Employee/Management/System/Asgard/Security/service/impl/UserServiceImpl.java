package Employee.Management.System.Asgard.Security.service.impl;

import Employee.Management.System.Asgard.Security.entity.dto.UserDTO;
import Employee.Management.System.Asgard.Security.entity.User; // Assuming there is a User entity
import Employee.Management.System.Asgard.Security.repository.UserRepository; // Assuming there is a User repository
import Employee.Management.System.Asgard.Security.service.UserService;
import Employee.Management.System.Asgard.Security.service.mapper.UserMapper; // Assuming there is a User mapper
import Employee.Management.System.Asgard.Security.service.validator.UserValidator; // Assuming there is a User validator
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, UserValidator validator) {
        this.userRepository = repository;
        this.userMapper = mapper;
        this.userValidator = validator;
    }

    @Override
    public UserDTO createUser (UserDTO userDTO) {
        userValidator.validateForCreate(userDTO);
        User entity = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(entity));
    }
}
