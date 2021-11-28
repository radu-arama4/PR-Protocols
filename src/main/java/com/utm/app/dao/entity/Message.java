package com.utm.app.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long messageId;

  @Column private Long fromUserId;
  @Column private Long toUserId;
  @Column private String title;
  @Column private String message;
}
