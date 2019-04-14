package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

    public static void main(String[] args) {
        
        //session factory
        SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            // use session to save object & create a transaction
            Student tempStudent = new Student("Paul", "Wall", "paul@lol.com");
            session.beginTransaction();
            
            System.out.println("Saving student");
            session.save(tempStudent);
            
            session.getTransaction().commit(); 
            
            
            
        } finally {
            factory.close();
        }

    }

}
