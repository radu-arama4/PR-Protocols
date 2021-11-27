package com.utm.app.dto;

import lombok.Data;

@Data
public class MessageDto {
  private Long messageId;
  private String to;
  private String from;
  private String title;
  private String message;
}
