package com.utm.app.service.impl;

import com.utm.app.dao.entity.User;
import com.utm.app.dao.UserRepository;
import com.utm.app.dto.UserDto;
import com.utm.app.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDto createNewUser(UserDto user) {
    User userToBeCreated = new User();
    BeanUtils.copyProperties(user, userToBeCreated);
    userToBeCreated.setId(userToBeCreated.getId());
    return user;
  }
}
