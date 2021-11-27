package com.utm.app.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Message {
  @Id private Long messageId;
  @OneToOne private User from;
  @OneToOne private User to;
  @Column private String title;
  @Column private String message;
}
