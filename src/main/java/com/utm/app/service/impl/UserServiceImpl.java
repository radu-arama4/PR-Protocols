package com.utm.app.service.impl;

import com.utm.app.controller.dto.request.AddUserToContactListDto;
import com.utm.app.controller.dto.request.RemoveUserFromContactListDto;
import com.utm.app.dao.entity.User;
import com.utm.app.dao.UserRepository;
import com.utm.app.controller.dto.UserDto;
import com.utm.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
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

  @Override
  public UserDto addUserToContactsList(AddUserToContactListDto user) {
    User userToBeAdded = userRepository.getByUsername(user.getUsername());

    if (userToBeAdded == null) {
      log.warn("No user with such username!");
      return null;
    }

    User currentUser = userRepository.getById(user.getIdOfCurrentUser());
    currentUser.addToContactList(userToBeAdded);

    UserDto addedUser = new UserDto();

    BeanUtils.copyProperties(userToBeAdded, addedUser);

    return addedUser;
  }

  @Override
  public UserDto removeUserFromContactsList(RemoveUserFromContactListDto user) {
    User userToBeRemoved = userRepository.getById(user.getIdOfUserToRemove());
    User currentUser = userRepository.getById(user.getIdOfCurrentUser());

    currentUser.addToContactList(userToBeRemoved);

    UserDto removedUser = new UserDto();
    BeanUtils.copyProperties(userToBeRemoved, removedUser);

    return removedUser;
  }
}
