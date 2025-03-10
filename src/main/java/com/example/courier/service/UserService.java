package com.example.courier.service;
import com.example.courier.dto.UserDto;
import java.util.List;
public interface UserService {
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    UserDto updateUser(Long id, UserDto userDto);
    boolean deleteUser(Long id);
}
