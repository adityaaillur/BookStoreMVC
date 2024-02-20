/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info6250.dao;

import com.info6250.pojo.Book;
import com.info6250.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author adityaillur
 */
@Component
public class bookDao extends Dao {

    public void saveBook(Book book) {
        try {
            begin();
            getSession().persist(book);
            commit();
        } catch (HibernateException e) {
            rollback();
        }
    }

    public List<Book> getAllBooks() {
        Query que = getSession().createNamedQuery("allbooks", Book.class);
        return que.list();
    }

    public List<Book> getBooksByUserId(int id) {
        String hql = "FROM Book WHERE userId = :id";
        Query<Book> query = getSession().createQuery(hql, Book.class);
        query.setParameter("id", id);
        return query.list();
    }

    public void deleteBook(int id) {
        try {
            begin();
            Query query = getSession().createQuery("DELETE FROM Book WHERE bkid = :id");
            System.out.println(query);
            query.setParameter("id", id);
            query.executeUpdate();
            commit();
        } catch (HibernateException e) {
            rollback();
        }
    }

    public Book getBookById(int id) {
        String hql = "FROM Book WHERE bkid = :id";
        try {
            begin();
            Query<Book> query = getSession().createQuery(hql, Book.class);
            query.setParameter("id", id);
            Book book = query.uniqueResult();
            commit();
            return book;
        } catch (HibernateException e) {
            rollback();
            return null;
        }
    }
    
    public void updateBook(Book book) {
        try {
            begin();
            getSession().merge(book);
            commit();
        } catch (HibernateException e) {
            rollback();
        }
    }

}
