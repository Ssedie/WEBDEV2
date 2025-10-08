package com.zed.student.Controller.api;


import com.zed.student.DTO.AuthRequest;
import com.zed.student.DTO.AuthResponse;
import com.zed.student.Service.JwtTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class ApiAuthControl {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public ApiAuthControl(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        System.out.println("🔥 /api/auth/login was called");
        System.out.println("Username: " + authRequest.username());
        System.out.println("Password: " + authRequest.password());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.username(),
                        authRequest.password()
                )
        );

        String token = jwtTokenService.generateToken(authentication);
        Long expAt = jwtTokenService.extractExpiration(token);

        return new AuthResponse(token, authentication.getName(), expAt);
    }

    @GetMapping("/validate")
    public String validate() {
        return "valid";
    }

}

