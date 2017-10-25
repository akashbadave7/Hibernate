package com.bridgeit.program;


import java.util.Scanner;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class StoreData 
{  
public static void main(String[] args) 
{  
      
    //creating configuration object  
	
	Scanner scanner = new Scanner(System.in);
    Configuration configure=new Configuration();  
    configure.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating seession factory object  
    SessionFactory factory=configure.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction transaction=session.beginTransaction();  
    System.out.println("Enter id");
    int id = scanner.nextInt();
    System.out.println("Enter First name");
    String firstName = scanner.next();
    System.out.println("Enter last name");
    String lastName = scanner.next();
    Employee employee=new Employee();  
    
    employee.setId(id);  
    employee.setFirstName(firstName);  
    employee.setLastName(lastName);  
      
    session.persist(employee);//persisting the object  
      
    transaction.commit();//transaction is committed  
    session.close();  
      
    System.out.println("successfully inserted");  
      
}  
}  