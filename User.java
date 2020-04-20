package fms;

import java.sql.*;

import javax.swing.JOptionPane;

public class User
{

	static String[][] selected_items = new String[10][10];
	static int l=-1;
	static String contact1=null;
	static int[] selected_items_price = new int[10];
	static int[] selected_items_quantity = new int[10];
	/**
	 * @param args the command line arguments
	 */
	User() {
	
//		InputDialogWithDropdownListbox();
	  userInterface();
	}
	
	
	
	public static void userInterface() {
		
		 String[] options = {"SignUp", "SIgnIn"};
	     
	      int x = JOptionPane.showOptionDialog(null, "Hello",
	              "Click a button",
	              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	      
	      if(x==0) 
	    	  signUp(2);
	      else if(x==1)
	    	  signIn();
	    	  
	}
	
	
	public static void signUp(int check) {
		
		try {
  		  
  		  
				  		  String id = JOptionPane.showInputDialog("Enter id"); 
				  			
				  		  String name = JOptionPane.showInputDialog("Enter name");
							
				  		  String address = JOptionPane.showInputDialog("Enter address");
				  		  
				  		  String contact1 = JOptionPane.showInputDialog("Enter contact number");
				  		  
				  		  Integer contact = Integer.parseInt(contact1);
							
						  Connection con=DriverManager.getConnection(Connection1.url);  
				
					      
						    Statement stmt=con.createStatement();
							stmt.executeUpdate("insert into customer values('"+id+"','"+name+"','"+address+"',"+contact+")");  
							if(check==1) {
								System.out.println("adddddddddd"+check); 
								 Admin.adminInterface();
							 }
							 else if(check==2)
								 userInterface();	
						
						 } catch(Exception e) {
							 System.out.println(e);
							 JOptionPane.showMessageDialog(null, "Invalid entry", "Task failed", JOptionPane.PLAIN_MESSAGE);
							 if(check==1) {
								System.out.println("adddddddddd"+check); 
								 Admin.adminInterface();
							 }
							 else if(check==2)
								 userInterface();
								 
							 //display incorrect password message
							System.exit(0);
							
						 }
				
	}
	
	public static void signIn() {
		
		
		try {
	  		  
			 System.out.println("TEST6");
	  		  String id = JOptionPane.showInputDialog("Enter id"); 
	  
	  		  contact1 = JOptionPane.showInputDialog("Enter contact number");
	  		  
	  		  Integer contact = Integer.parseInt(contact1);
				
			  Connection con=DriverManager.getConnection(Connection1.url);  
	
		      
			    Statement stmt=con.createStatement();
			    System.out.println("TEST7");
			    ResultSet rs_user=stmt.executeQuery("select * from customer where id='"+id+"' AND contactno="+contact+"");
				
			    System.out.println("TEST6");
			    if (!rs_user.isBeforeFirst() ) {    
			        System.out.println("No data");
			        throw new Exception();
			    } 
			    
			    else {
			    
			    while(rs_user.next())
			    {
			    if(rs_user.getString(1).equals(id)) {
					
					System.out.println("jcbshbjsnfjkenfejrebnsj");
					l=-1;
					placeOrder();
				}
			    }
			    
			    }
			    
						
			 } catch(Exception e) {
				 System.out.println(e);
				 String[] options = {"Try again","Home"};
			     
			      int x = JOptionPane.showOptionDialog(null, "Invalid User ",
			              "Click Home to return",
			              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			      
			      if(x==0) 
			    	  signIn();
			      else if(x==1)
			    	  Fmsinterface.main(null);
				System.exit(0);
				
			 }
		
		
		
	}
	
	
	
	
	
	
	
	public static void placeOrder() {
		 
		    
			try {
				
				System.out.println("TESTtttttttttttttttttttt"+l);
				l++;
				
				String[] choices = new String[100];	  
		  		  
				
					
				  Connection con=DriverManager.getConnection(Connection1.url);  
		
			      
				    Statement stmt=con.createStatement();
				    
				    ResultSet rs_food=stmt.executeQuery("select * from food");
				  
				    
				    
				    int i=1,k=0;
				    
				    while(rs_food.next())
				    {
//				    	+Integer.toString(rs_food.getInt(i)
				    	System.out.println(rs_food.getInt(i+1));
				    	System.out.println(choices[k]);
				    	choices[k]= rs_food.getString(i);
				    	 System.out.println(choices[k]);
				    	k++;
				    	
				    	System.out.println("abc");
				 
				    
				    }
				    
				    
				    String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
					        "Select food", JOptionPane.QUESTION_MESSAGE, null, // Use
					                                                                       // default
					        
					        // icon
					        choices, // Array of choices
					        choices[1]);
				    
				    // Initial choice
				    
				    String quantity=null,price=null;
				    
				    if(input!=null) {
				    	
					    ResultSet rs_food_price=stmt.executeQuery("select price from food where name='"+input+"'");
					    while(rs_food_price.next())
					    {
					    	price=Integer.toString(rs_food_price.getInt(1));
					    	
					    	quantity = JOptionPane.showInputDialog("Price="+rs_food_price.getInt(1)+"  Enter quantity");
					    
					    }
					    
				    	 
				    }
				    
				    else {
				    	
				    	
				    	Fmsinterface.main(null);
				    	
				    }
				    
				    if(quantity!=null) {
				    	
				    	
				    	selected_items[l][l]=input;
				    	selected_items[l][l+1]=quantity;
				    	selected_items[l][l+2]=price;
				    	selected_items_price[l]=Integer.parseInt(price);
				    	selected_items_quantity[l] = Integer.parseInt(quantity);
				    	
				    	String[] options = {"Finish Order", "Order more"};
					     
					      int x = JOptionPane.showOptionDialog(null, "Order placed ",
					              "Click a button",
					              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					      int sum1=0;
					      int countt=0;
					      if(x==0) {
					    	  
					    	  ResultSet rs = stmt.executeQuery("select count(*) from orderdetails");
					    	  while(rs.next())
					    		  countt = rs.getInt(1);
					    	      countt = 1000+countt;
					    	  int[] sum = new int[l+1];
					    	  for(int d=0;d<=l;d++) {
						    	
					    		  System.out.println("TEST1"+l);
					    		sum[d]=selected_items_price[d]*selected_items_quantity[d];
					    		System.out.println("TEST2");  
					    		sum1=sum1+sum[d];
						    	

					    		
					    		  stmt.executeUpdate("insert into orderdetails2 values("+countt+",'"+
					    				selected_items[d][d]+"',"+selected_items_quantity[d]+","+
					    				sum[d]+")");
					    	
					    	  }
					    	  
					    	  
					    	  
					    	  stmt.executeUpdate("insert into orderdetails values("+countt+",'"+
					    				contact1+"',"+sum1+")");  
					    	  
					    	  
					    	  
							//stmt.executeUpdate("insert into customer values('"+id+"','"+name+"','"+address+"',"+contact+")");
					    	JOptionPane.showMessageDialog(null,"Your Order has been placed");
					    	Fmsinterface.main(null);
					    	  
					      }
					      else if(x==1)
					    	  
					    	  placeOrder();
					    	  
				    	
				    	
				    }
				    
				    
							
				 } catch(Exception e) {
					 System.out.println(e);
					signIn();
					System.exit(0);
					
				 }
		
		    
		    
		    
		  }
		
	
	
	
}
