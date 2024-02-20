/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.info6250.controller;

import com.info6250.view.pdfViewImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.View;

/**
 *
 * @author adityaillur
 */

@Controller
public class aboutController  {
    @GetMapping("/about.pdf")
    public View handleRequestGet() {
        
        View view = new pdfViewImpl();
        return view;
        
        
    }
}
