package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        
        //session factory
        SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        
        
        
        try {
            int studentId = 1;
            Session session = factory.getCurrentSession();
            // use session to save object & create a transaction
            session.beginTransaction();
            
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Saving student");
            System.out.println("This student " + myStudent);
            
            myStudent.setFirstName("scoob");
            
            session.getTransaction().commit(); 
            
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            System.out.println("Updating all emails");
            
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            
            session.getTransaction().commit();
            
            
            
        } finally {
            factory.close();
        }

    }

}
