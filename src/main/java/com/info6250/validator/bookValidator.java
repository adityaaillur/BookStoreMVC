/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info6250.validator;

import com.info6250.pojo.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author adityaillur
 */

@Component
public class bookValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Book.class.isAssignableFrom(type);
        
    }

    @Override
    public void validate(Object model, Errors err) {
        ValidationUtils.rejectIfEmptyOrWhitespace(err, "bkisbn", "Empty_ISBN", "ISBN Cannot be Empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(err, "bktitle", "Empty_Title", "Titile Cannot be Empty");

        Book book = (Book) model;
        
        if(book.getImage().getSize() == 0)
            err.rejectValue("image", "Empty-File", "INo Files");
        
        if(!book.getImage().getOriginalFilename().endsWith("png")) {
            err.rejectValue("image", "Invalid-Files", "PNG Files only");
        }
         
    }
    
}
