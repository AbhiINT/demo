package com.user_signin_login.registration_portal.Application.mapper.adminToAdminDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user_signin_login.registration_portal.Application.Model.user.User;
import com.user_signin_login.registration_portal.Application.dto.UserDTO;

@Service
public class UserMapper {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    public List<UserDTO> convertAdminListToUserDTOList(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhoneNumber(user.getPhoneNumber());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
