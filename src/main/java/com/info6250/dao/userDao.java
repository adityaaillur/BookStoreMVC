/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info6250.dao;

import com.info6250.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author adityaillur
 */

@Component
public class userDao extends Dao {
    public User checkLogin(String username, String password) {
        Query<User> q = getSession().createQuery("FROM User WHERE uname = :uname AND pass = :pass", User.class);
        q.setParameter("uname", username);
        q.setParameter("pass", password);
        
        return q.uniqueResult();
        
    }
    
    public boolean saveUser(User user) {
        try {
            begin();
            getSession().persist(user);
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            return false;
        }
    }
    
    // other methods...
}
    
//    public boolean createLogin(String uname, String pass) {
//        User account = new User();
//        
//        account.setUname(uname);
//        account.setPass(pass);
//        
//        begin();
//        getSession().persist(account);
//        commit();
//        
//        return true;
//    }

