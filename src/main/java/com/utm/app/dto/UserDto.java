package com.utm.app.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class UserDto {
  private Long id;
  private String username;
}
