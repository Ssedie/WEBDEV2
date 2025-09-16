//package com.zed.prelimss.controller;
//
//
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class AuthController {
//
//     public AuthController(){
//     }
//
//     @GetMapping("/login")
//    public String login(Authentication authentication) {
//        if (authentication != null && authentication.isAuthenticated()
//                && !(authentication.getPrincipal() instanceof String)) {
//            return "redirect:/";
//        }
//
//        return "login";
//     }
//}
