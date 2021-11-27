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
  @OneToMany private List<User> contactList;
  @OneToMany private List<Message> receivedMessages = new LinkedList<>();
  @OneToMany private List<Message> sentMessages = new LinkedList<>();

  public User(String username) {
    this.username = username;
  }

  public User() {}

  public void addToContactList(User user) {
    if (!contactList.contains(user)) {
      contactList.add(user);
      user.addToContactList(this);
    }
  }
}
