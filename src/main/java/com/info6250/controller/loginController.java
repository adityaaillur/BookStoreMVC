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
public class loginController {
    @GetMapping("/login.htm")
    public String loginForm() {
        return "loginPage";
    }
    
    @PostMapping("/login.htm")
    public String loginCheck(HttpServletRequest request, userDao udao) {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        User userObject = udao.checkLogin(user, pass);
        
        if (userObject!=null) {
//            return "books";
            HttpSession session = request.getSession();
            session.setAttribute("user", userObject);
            return "accountPage";
            // user name is in the session (userDao)
        }
        
        else
            return "redirect:/login.htm";
    }
    
    @GetMapping("/login/create.htm")
    public String loginCreateGet() {
        return "register";
    }
    
//    @PostMapping("/signup")
//    public String loginCreatePost() {
//        return "RegisterSuccess";
//    }
    
    @PostMapping("/login/signup.htm")
    public String loginCreatePost(HttpServletRequest request, userDao udao) {
        System.out.println("adafjd");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User account = new User();
        account.setUname(username);
        account.setPass(password);

        if (udao.saveUser(account)) {
            return "registerSuccess";
        } else {
            // Handle registration failure
            return "error";
        }
    }
    
    @GetMapping("/logout.htm")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login.htm";
    }
    
}
