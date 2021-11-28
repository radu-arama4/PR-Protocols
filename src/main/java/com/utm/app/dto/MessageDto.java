package com.utm.app.dto;

import lombok.Data;

@Data
public class MessageDto {
  private Long messageId;
  private Long toUserId;
  private Long fromUserId;
  private String title;
  private String message;
}
