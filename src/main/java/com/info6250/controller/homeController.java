/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info6250.controller;


import com.info6250.dao.userDao;
import com.info6250.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author adityaillur
 */



@Controller
public class homeController {
    @GetMapping("/home.htm")
    public String loginForm() {
        return "homePage";
    }
    
    @GetMapping("/accountPage.htm")
    public String accountPage() {
        return "accountPage";
    }
    
}




