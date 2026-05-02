package edu.icet.ecom.service;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.entity.Role;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO findByUsername(String username);
    List<UserDTO> getAllUsers();
    List<UserDTO> getUsersByRole(Role role);
    boolean deleteUser(Long id);
}
