package global.govstack.user_service.service;

import global.govstack.user_service.mapper.UserMapper;
import global.govstack.user_service.models.PermissionEnum;
import global.govstack.user_service.models.dtos.UserFullDto;
import global.govstack.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserFullDto> getAllUsers() {
        return this.userRepository.findAll().stream().map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<UserFullDto> getUser(UUID userId) {
        return this.userRepository.findOneByUserUUID(userId)
                .map(userMapper::entityToDto);
    }

    public boolean checkIfUserCanBroadcast(UUID userUuid, int countryId) {
        return this.userRepository.checkIfUserCanBroadcast(userUuid, PermissionEnum.BROADCAST.getName(), countryId).isPresent();
    }

    public Optional<UserFullDto> findUserByEmail(String email) {
        return this.userRepository.findOneByEmailIgnoreCase(email)
                .map(userMapper::entityToDto);
    }

}
