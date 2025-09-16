//package com.zed.prelimss.service;
//
//import com.zed.prelimss.Class.User;
//import com.zed.prelimss.exception.UsernameNotFoundException;
//import com.zed.prelimss.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    private final PasswordEncoder passwordEncoder;
//    UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//
//        if(username.equals("admin")){
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username("admin")
//                    .password(passwordEncoder.encode("admin123"))
//                    .build();
//        }
//
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .build();
//
//    }
//
//
//}
