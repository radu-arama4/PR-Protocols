package com.utm.app.service;

import com.utm.app.dto.UserDto;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
  UserDto createNewUser(UserDto user);
}
