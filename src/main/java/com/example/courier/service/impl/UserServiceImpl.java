package com.example.courier.service.impl;
import com.example.courier.dao.UserRepository;
import com.example.courier.dto.UserDto;
import com.example.courier.model.User;
import com.example.courier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
@Override
    public UserDto createUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
    }
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? convertToDto(user) : null;
    }
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(userDto.getName());
            existingUser.setEmail(userDto.getEmail());
            userRepository.save(existingUser);
            return convertToDto(existingUser);
        }
        return null; // Return null if user not found
    }
    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false; // Return false if user not found
    }
    // Helper method to convert User entity to UserDto
    private UserDto convertToDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
    // Helper method to convert UserDto to User entity
    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
