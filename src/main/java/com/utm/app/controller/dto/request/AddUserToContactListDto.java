package com.utm.app.controller.dto.request;

import lombok.Data;

@Data
public class AddUserToContactListDto {
    private String username;
    private Long idOfCurrentUser;
}
