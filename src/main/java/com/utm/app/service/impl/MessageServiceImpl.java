package com.utm.app.service.impl;

import com.utm.app.dao.entity.Message;
import com.utm.app.dao.entity.User;
import com.utm.app.dao.UserRepository;
import com.utm.app.dto.MessageDto;
import com.utm.app.dto.UserDto;
import com.utm.app.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Log4j2
public class MessageServiceImpl implements MessageService {
  private final JavaMailSender mailSender;
  private final UserRepository userRepository;

  @Autowired
  public MessageServiceImpl(JavaMailSender mailSender, UserRepository userRepository) {
    this.mailSender = mailSender;
    this.userRepository = userRepository;
  }

  @Override
  public String sendMessage(MessageDto message) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();

    mailMessage.setTo(message.getTo());
    mailMessage.setText(message.getMessage());
    mailMessage.setSubject(message.getTitle());
    mailMessage.setReplyTo(message.getFrom());

    try {
      mailSender.send(mailMessage);
    } catch (Exception e) {
      log.error(e);
    }

    return "Mail sent successfully...";
  }

  @Override
  public List<MessageDto> getReceivedMessages(UserDto user) {
    User existingUser = userRepository.getById(user.getId());

    List<Message> receivedMessages = existingUser.getReceivedMessages();
    List<MessageDto> receivedMessagesToReturn = new LinkedList<>();

    receivedMessages.forEach(
        message -> {
          MessageDto messageDto = new MessageDto();
          BeanUtils.copyProperties(message, messageDto);
          receivedMessagesToReturn.add(messageDto);
        });

    return receivedMessagesToReturn;
  }

  @Override
  public List<MessageDto> getSentMessages(UserDto user) {
    User existingUser = userRepository.getById(user.getId());

    List<Message> receivedMessages = existingUser.getSentMessages();
    List<MessageDto> receivedMessagesToReturn = new LinkedList<>();

    receivedMessages.forEach(
        message -> {
          MessageDto messageDto = new MessageDto();
          BeanUtils.copyProperties(message, messageDto);
          receivedMessagesToReturn.add(messageDto);
        });

    return receivedMessagesToReturn;
  }
}
