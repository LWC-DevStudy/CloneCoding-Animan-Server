package com.clone.animan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignupRequestDto {

    private String name;
    private String username;
    private String password;
    private String passwordCheck;
    private boolean admin = false;
    private String adminToken = "";
}