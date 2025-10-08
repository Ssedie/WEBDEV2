package com.zed.student.DTO;

public record AuthResponse(String token, String username, Long exp) {
}
