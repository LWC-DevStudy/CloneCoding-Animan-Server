package com.clone.animan.service;


import com.clone.animan.domain.User;
import com.clone.animan.dto.request.SignupRequestDto;
import com.clone.animan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String passwordChecker = requestDto.getPasswordCheck();
        String name = requestDto.getName();

        Optional<User> found = userRepository.findByUsername(username);
        if (username.equals("") || password.equals("") || passwordChecker.equals("")) {
            throw new IllegalArgumentException("username || password || passwordChecker가 비어있습니다.");
        } else if (password.length() < 4) {
            throw new IllegalArgumentException("password는 최소 4글자입니다.");
        } else if (!password.equals(passwordChecker)) {
            throw new IllegalArgumentException("password와 passwordChecker가 다릅니다.");
        } else if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }
        password = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(name, username, password);
        userRepository.save(user);
    }


    public Map<String, String> getUserIndo(User user) {

        User user1 = userRepository.findById(user.getUserId()).orElseThrow(
                ()-> new NullPointerException("해당 회원이 없스니다.")
        );

        Map<String ,String > map  = new HashMap<>(1);
        map.put("username", user1.getUsername());
        return map;


    }
}