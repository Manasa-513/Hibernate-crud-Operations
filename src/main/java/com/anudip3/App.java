package com.anudip3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anudip3.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Configuration cfg=new Configuration();
         cfg.configure("hibernate.cfg.xml");
         SessionFactory factory=cfg.buildSessionFactory();
         Session session=factory.openSession();
         try 
         {
        	//Insert user details into user table
        	 
        	 for(int i=1;i<=10;i++)
        	 {  		
        		User user=new User();
        		user.setUserName("user"+i);
        		session.save(user);
  	         }
  	         
        	 
        	 
        	 //Retrieve the details of a user
        	 
        	 
        	 User user=session.get(User.class, 9);
        	 System.out.println("user name:"+user.getUserName());
        	 
        	 
        	 //Update the User
        	 
        	 User user1=session.get(User.class, 14);
        	 user.setUserName("new-user 14");
        	 session.update(user);
        	// session.save(user);
        	 
        	 
        	 //Delete the User
        	 
        	 User user2=session.get(User.class, 12);
        	 session.delete(user);
        	 
         	
         	session.beginTransaction();
         	
         	session.getTransaction().commit();
         	
    
         }
         catch(Exception e)
         {
         	e.printStackTrace();
         }
         finally 
         {
         	session.close();
         	factory.close();
         }

    }
}
