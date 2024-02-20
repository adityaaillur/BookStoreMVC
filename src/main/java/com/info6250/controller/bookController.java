/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/AbstractController.java to edit this template
 */
package com.info6250.controller;

import com.info6250.dao.bookDao;
import com.info6250.pojo.Book;
import com.info6250.pojo.User;
import com.info6250.validator.bookValidator;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static javax.ws.rs.core.Response.status;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import static org.springframework.web.reactive.function.server.ServerResponse.status;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author adityaillur
 */
@Controller
public class bookController {

    @Autowired
    bookValidator validator;

    @RequestMapping(value = "/book/add.htm", method = RequestMethod.GET)
    public String DisplayBook(HttpServletRequest request, ModelMap model, Book book) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "redirect:/login.htm";
        };
        System.out.println("HI");

        book.setBkisbn("234");
        book.setBktitle("random");
        System.out.println("HI");

        model.addAttribute("book", book);
//        setCommandName("user");
//        setCommandClass("User.class");
        return "redirect:/login.htm";
        //return "Hi";
    }

    @GetMapping("/book/form.htm")
    public String formBook(HttpServletRequest request, @ModelAttribute("book") Book book) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "redirect:/login.htm";
        };
        return "bookForm";
    }

    @PostMapping("/book/add.htm")
    public String displayAdded(HttpServletRequest request, @ModelAttribute("book") Book book, BindingResult res, SessionStatus stat, bookDao bookdao, ModelMap model) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "redirect:/login.htm";
        };
        validator.validate(book, res);
        try {
            if (res.hasErrors()) {
                return "bookForm";
            }

            String fName = book.getImage().getOriginalFilename();
            System.out.println(book.getImage().getOriginalFilename());
//            FileUtils.writeByteArrayToFile(new File("/Users/adityaillur/Desktop/WebtoolsFinalProject/uploads", fName), book.getImage().getBytes());
            File f = new File("/Users/adityaillur/Desktop/WebtoolsFinalProject/uploads", book.getBkisbn() + ".png");
            //book.setBktitle(fName);
            book.getImage().transferTo(f);
            book.setImageFilePath(book.getBkisbn() + ".png");
            System.out.println((User) request.getAttribute("user"));
            System.out.println("daksjndaksj");
            book.setUserId(((User) session.getAttribute("user")).getUid());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
            //Logger.getLogger(bookController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            System.out.println("IOException: " + ex.getMessage());
            //Logger.getLogger(bookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //current handler session has completed processing
        stat.setComplete();
        bookdao.saveBook(book);
        model.addAttribute("action", "Added");

//            Configuration cfg = new Configuration();     
//            
//            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
//            Session session = sf.openSession();
//            
//            Transaction trx = session.beginTransaction();
//            
//            session.persist(book);
//            trx.commit();
        return "bookAdded";

    }

    @PostMapping("/book/updateanddelete.htm")
    public String deleteBook(ModelMap model, HttpServletRequest request, @RequestParam(value = "selectedBook") String id, bookDao bookdao) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "redirect:/login.htm";
        }
//String isbn = request.getParameter("selectedBook");
        if (request.getParameter("update") != null) {
            Book book = bookdao.getBookById(Integer.parseInt(id));
            model.addAttribute("book", book);
            return "updateForm";

        } else if (request.getParameter("delete") != null) {
            bookdao.deleteBook(Integer.parseInt(id));
            return "redirect:/book/all.htm";
        }
        return "redirect:/login.htm";

    }

//    @GetMapping("/book/update.htm")
//    public String formUpdateBook(HttpServletRequest request, @RequestParam("isbn") String i, ModelMap model,
//            bookDao bookdao) {
//        HttpSession session = request.getSession();
//        if (session.getAttribute("user") == null) {
//            return "redirect:/login.htm";
//        }
//        
//        Book book = bookdao.getBookByIsbn(isbn);
//        model.addAttribute("book", book);
//        return "updateForm";
//    }
    @PostMapping("/book/update.htm")
    public String updateBook(HttpServletRequest request, @ModelAttribute("book") Book book, BindingResult res, SessionStatus stat, bookDao bookdao, ModelMap model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "redirect:/login.htm";
        }

        validator.validate(book, res);
        if (res.hasErrors()) {
            return "redirect:/book/all.htm";
        }

        try {
            if (book.getImage() != null) {
//                String fileName = book.getImage().getOriginalFilename();
                File file = new File("/Users/adityaillur/Desktop/WebtoolsFinalProject/uploads", book.getBkisbn() + ".png");
                book.getImage().transferTo(file);
            }

            book.setUserId(((User) session.getAttribute("user")).getUid());
            bookdao.updateBook(book);
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        } catch (IllegalStateException ex) {
            System.out.println("IllegalStateException: " + ex.getMessage());
        }

        stat.setComplete();
        model.addAttribute("action", "Updated");
        return "bookAdded";
    }

    @GetMapping("/book/search.htm")
    public String handleSearchGet() {
        return "";
    }

    @PostMapping("/book/search.htm")
    public String handleSearchPost() {
        return "";
    }

    @GetMapping("/book/all.htm")
    public ModelAndView allBooks(HttpServletRequest request, bookDao bookdao) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return new ModelAndView("loginPage");
        };

        User user = (User) session.getAttribute("user");
        List<Book> userBooks = bookdao.getBooksByUserId(user.getUid());

        return new ModelAndView("books", "bookList", userBooks);
    }

}
