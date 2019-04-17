package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
      //session factory
        SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            // use session to save object & create a transaction
            Student tempStudent1 = new Student("Paul", "Wall", "paul@lol.com");
            Student tempStudent2 = new Student("Ray", "Zhang", "ray@lol.com");
            Student tempStudent4 = new Student("bob", "lao", "bob@lol.com");
            session.beginTransaction();
            
            System.out.println("Saving student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            
            session.getTransaction().commit(); 
            
            
            
        } finally {
            factory.close();
        }


    }

}
