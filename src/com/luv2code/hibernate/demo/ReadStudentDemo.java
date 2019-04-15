package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

    public static void main(String[] args) {
        
        //session factory
        SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            // use session to save object & create a transaction
            Student tempStudent = new Student("Duff", "Duck", "duff@lol.com");
            session.beginTransaction();
            
            System.out.println("Saving student");
            session.save(tempStudent);
            
            session.getTransaction().commit(); 
            
            System.out.println("generated id: " + tempStudent.getId());
            
            //get session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nGetting student id: "+  tempStudent.getId());
            
            Student myStudent = session.get(Student.class, tempStudent.getId());
            
            System.out.println("Get complete: " + myStudent);
            session.getTransaction().commit();
            //retrieve student based on id
            
            //commit transaction
            
            System.out.println("done");
            
            
            
        } finally {
            factory.close();
        }

    }

}
