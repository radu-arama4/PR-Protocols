package com.utm.app.service;

import com.utm.app.controller.dto.request.AddUserToContactListDto;
import com.utm.app.controller.dto.UserDto;
import com.utm.app.controller.dto.request.RemoveUserFromContactListDto;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
  UserDto createNewUser(UserDto user);
  UserDto addUserToContactsList(AddUserToContactListDto user);
  UserDto removeUserFromContactsList(RemoveUserFromContactListDto user);
}
