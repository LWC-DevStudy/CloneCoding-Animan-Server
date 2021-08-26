package com.clone.animan.dto.response;


import lombok.Data;

@Data
public class TokenResponseDto {

    private String token;
    private Long userId;
    private String username;
}
