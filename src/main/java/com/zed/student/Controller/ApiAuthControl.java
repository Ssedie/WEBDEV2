//package com.zed.student.Controller;
//
//
//import com.zed.student.Class.JWUtil;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class ApiAuthControl {
//
//    private final JWUtil jwtUtil;
//
//    public ApiAuthControl(JWUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody Map<String, String> user) {
//        String username = user.get("username");
//        String password = user.get("password");
//
//        // Simple check (in real apps: check database + password hashing)
//        if ("alice".equals(username) && "password".equals(password)) {
//            return jwtUtil.generateToken(username);
//        } else {
//            throw new RuntimeException("Invalid login");
//        }
//    }
//}
//
