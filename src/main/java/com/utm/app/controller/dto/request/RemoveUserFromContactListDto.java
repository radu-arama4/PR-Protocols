package com.utm.app.controller.dto.request;

import lombok.Data;

@Data
public class RemoveUserFromContactListDto {
    private Long idOfCurrentUser;
    private Long idOfUserToRemove;
}
