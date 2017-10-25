package com.bridgeit.DAO;



import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bridgeit.Model.UserDetails;


public class DataBase 
{
/*	final String JDBC_Driver = "com.mysql.jdbc.Driver";
	final String DB_Url = "jdbc:mysql://localhost:3306/akash";
	
	//Database credential
	final String username = "root";
	final String password = "root";
	Connection connection=null;
	ResultSet resultSet=null;*/
	
	
    private Session session=null;
    
    private Configuration configure=new Configuration().configure("hibernate.cfg.xml");  
    
      
    //creating seession factory object  
   private SessionFactory sessionFactory=configure.buildSessionFactory();  
    
	public UserDetails getEmail(UserDetails userDetails)
	{
		try {
				session=sessionFactory.openSession();
				TypedQuery<UserDetails> query = session.createQuery("from registration where email = :email"
						+" and password = :password");
				query.setParameter("email",userDetails.getEmail());
				query.setParameter("password",userDetails.getPassword());
				
				List<UserDetails> list = query.getResultList();
			
			if (list.isEmpty()) 
			{ 
				System.out.println("Sorry, you are not a registered user! Please sign up first"); 
				userDetails.setValid(false); 
			} //if user exists set the isValid variable to true 
			else 
			{ 
				String name = list.get(1).toString(); 
				String mobile = list.get(4).toString();
				System.out.println(list);
				userDetails.setName(name); 
				userDetails.setMobile(mobile);
				userDetails.setValid(true); 
			} 
	
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetails;
		
	}
	public boolean insertUser(UserDetails user)
	{
		/*PreparedStatement prepareStatement = null;*/
		boolean flag=true;
		try
		{
			 session=sessionFactory.openSession();
		     session.beginTransaction();	
		     Transaction transaction=session.beginTransaction();  
			// reading data from signup.jsp page
			String email="";
			String mobile ="";
			Query query = session.createQuery("from registration where email='"+user.getEmail()+"' or mobilenumber='"+user.getMobile()+"'");
			List<String> list = query.getResultList();
			
			/*while (rs.next())*/
			if(!list.isEmpty())
			{
				email = list.get(2);
				mobile = list.get(4);
			}
			if(!(email.equals(user.getEmail()) || mobile.equals(user.getMobile())))
			{
				
				session.save(user);//persisting the object  
			      
			    transaction.commit();//transaction is committed  
			/*	prepareStatement.setString(1, user.getName());
				prepareStatement.setString(2, user.getEmail());
				prepareStatement.setString(3, user.getPassword());
				prepareStatement.setString(4, user.getMobile());
				prepareStatement.executeUpdate();*/
			}
			else
			{
				flag=false;
			}
			
			//setting values to attribute
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
}
