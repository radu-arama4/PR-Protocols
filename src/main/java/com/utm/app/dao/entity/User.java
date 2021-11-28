package com.utm.app.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String username;
  @Column private String emailAddress;
  @Column private String password;
  @OneToMany private List<User> contactList;
  @OneToMany private List<Message> receivedMessages = new LinkedList<>();
  @OneToMany private List<Message> sentMessages = new LinkedList<>();

  public User(String username, String emailAddress, String password) {
    this.username = username;
    this.emailAddress = emailAddress;
    this.password = password;
  }

  public User() {}

  public void addToContactList(User user) {
    if (!contactList.contains(user)) {
      contactList.add(user);
      user.addToContactList(this);
    }
  }

  public void addSentMessage(Message sentMessage) {
    sentMessages.add(sentMessage);
  }

  public void addReceivedMessage(Message receivedMessage) {
    receivedMessages.add(receivedMessage);
  }
}
