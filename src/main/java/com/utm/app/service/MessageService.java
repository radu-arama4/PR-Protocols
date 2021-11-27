package com.utm.app.service;

import com.utm.app.dto.MessageDto;
import com.utm.app.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
  String sendMessage(MessageDto messageDto);

  List<MessageDto> getReceivedMessages(UserDto user);

  List<MessageDto> getSentMessages(UserDto user);
}
