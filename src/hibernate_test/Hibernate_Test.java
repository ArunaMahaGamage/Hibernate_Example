/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate_test;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author aruna
 */
public class Hibernate_Test {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        System.out.println("Hi Aruna");
//    }
    
    public static void main(String[] args) {  
      
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("/hibernate_test/hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

SessionFactory factory = meta.getSessionFactoryBuilder().build();
Session session = factory.openSession();
Transaction t = session.beginTransaction(); 
          
    Employee e1=new Employee();  
    e1.setId(105);  
    e1.setFirstName("Gaurav");  
    e1.setLastName("Chawla");  
      
    session.save(e1);
	t.commit();
    System.out.println("successfully saved");  
	factory.close();
    session.close();  
      
}
    
}
