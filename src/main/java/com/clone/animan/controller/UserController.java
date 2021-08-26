package com.clone.animan.controller;

import com.clone.animan.domain.User;
import com.clone.animan.dto.request.SignupRequestDto;
import com.clone.animan.dto.response.TokenResponseDto;
import com.clone.animan.repository.UserRepository;
import com.clone.animan.security.JwtTokenProvider;
import com.clone.animan.security.UserDetailsImpl;
import com.clone.animan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserRepository userRepository;

    // 회원 가입 요청 처리
    @PostMapping("/user/register")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
    }


    @PostMapping("/user/login")
    public TokenResponseDto login(@RequestBody SignupRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 유저입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        TokenResponseDto tokenResponseDto = new TokenResponseDto();
        tokenResponseDto.setUserId(user.getUserId());
        tokenResponseDto.setToken(jwtTokenProvider.createToken(user.getUsername()));
        tokenResponseDto.setUsername(user.getUsername());
        return tokenResponseDto;
    }

    @GetMapping("/user/userinfo")
    public Map<String, String> loginCheck(@AuthenticationPrincipal UserDetailsImpl userDetails){

        return userService.getUserIndo(userDetails.getUser());

    }
}