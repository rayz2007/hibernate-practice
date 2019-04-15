package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

    public static void main(String[] args) {
        
        //session factory
        SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            // use session to save object & create a transaction
            session.beginTransaction();
            
            List<Student> theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
            
            displayStudents(theStudents);
            session.getTransaction().commit(); 
            
            
            
        } finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }

}
