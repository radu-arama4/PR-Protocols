package com.utm.app.controller;

import com.utm.app.dto.MessageDto;
import com.utm.app.dto.UserDto;
import com.utm.app.service.MessageService;
import com.utm.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired UserService userService;

  @Autowired MessageService messageService;

  @PostMapping()
  public UserDto createNewUser(@RequestBody UserDto user) {
    return userService.createNewUser(user);
  }

  @PostMapping("/message")
  public String sendMessage(@RequestBody MessageDto message) {
    return messageService.sendMessage(message);
  }

  @GetMapping("/message/received")
  public List<MessageDto> getReceivedMessages(@RequestBody UserDto user) {
    return messageService.getReceivedMessages(user);
  }

  @GetMapping("/message/sent")
  public List<MessageDto> getSentMessages(@RequestBody UserDto user) {
    return messageService.getSentMessages(user);
  }
}
