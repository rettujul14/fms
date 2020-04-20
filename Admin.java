package fms;

import java.sql.*;

import javax.swing.JOptionPane;

public class Admin
{
	
	static String id;
	static String pass;
	static String[][] selected_items = new String[10][10];
	static int l=-1;
	static String contact1=null;
	static int[] selected_items_price = new int[10];
	static int[] selected_items_quantity = new int[10];
	/**
	 * @param args the command line arguments
	 */
	
	Admin(){
		Admin_1();
	}
	
	  public static void adminInterface(){
		  
	  String[] options = {"Employee", "Order details", "Food", "User","LogOut"};
   
    int x = JOptionPane.showOptionDialog(null, "Hello Admin",
            "Click a button",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    if(x==0) {
  	  
  	  addEmployee();
    }
    if(x==1) {
  	  
  	  orderDetails();
    }
    else if(x==2) {
  	  addFood();
    }
    
    else if(x==3) {
    	  addUser();
      }
    else if(x==4) {
  	 Fmsinterface.main(null);;
    }
   
    
	  }

	
	
	
	public static void Admin_1() {
		
		try {
			
			
			 Connection con=DriverManager.getConnection(Connection1.url);  

				System.out.println("test2");
				Statement stmt=con.createStatement();
				ResultSet rs_admin=stmt.executeQuery("select * from admin");  
				while(rs_admin.next()) {
				id = rs_admin.getString(1);
				pass = rs_admin.getString(2);
				
				}
				System.out.println("testttttttttt"+id+pass);
					
				  		}catch(Exception e) {
				  			Fmsinterface.main(null);
			System.out.println(e);
		}
	

			
		

		
		String  id1 ="";
		String pass1 = "";
		
try {	   
id1 = JOptionPane.showInputDialog("Enter id"); // user  input password they like
		
pass1 = JOptionPane.showInputDialog("Enter your Password"); //user inputs there password

  if ((id1.equals(id))&&pass1.equals(pass)){
	  adminInterface();
  }	 
  
	else 
		
		JOptionPane.showMessageDialog(null, "You May Not Enter", "Authentication failed", JOptionPane.PLAIN_MESSAGE); //display incorrect password message

  		Admin_1();
	// terminate application if password is incorrect
}catch (Exception e) {
	Fmsinterface.main(null);
	// TODO: handle exception
}
	}
	
	
	
	
	
	
	public static void addEmployee() {
		
		 String[] options = {"Add", "Remove"};
	     
	      int x = JOptionPane.showOptionDialog(null, "Add/Remove Employee",
	              "Click a button",
	              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
      if(x==0) {
	    	  
    	  		
    	  try {
    		  
    		  
    		  String id = JOptionPane.showInputDialog("Enter id"); // user  input password they like
    			
    		  String pass = JOptionPane.showInputDialog("Enter Password"); //user inputs there password
  			
  			
 			 Connection con=DriverManager.getConnection(Connection1.url);  

 				System.out.println("test2");
 				Statement stmt=con.createStatement();
 				stmt.executeUpdate("insert into employee values("+id+","+pass+")");  
 				
 				adminInterface();
 				 }catch(Exception e) {
 					//JOptionPane.showMessageDialog(null, "Duplicate id", "Task failed", JOptionPane.PLAIN_MESSAGE); //display incorrect password message

 					adminInterface();
 					 System.exit(0);
 					 
 					 System.out.println("Duplicate id");
 				 }
    	  
    	  
    	  			
	      }
      
      else if(x==1) {
    	  
    	  
    	  		try {
    		  
    		  
    		  String id = JOptionPane.showInputDialog("Enter id"); // user  input password they like
    			
    		  
  			
  			
 			 Connection con=DriverManager.getConnection(Connection1.url);  

 				System.out.println("test2");
 				Statement stmt=con.createStatement();
 				stmt.executeUpdate("delete from employee where employee.id='"+id+"'");  
 				
 				adminInterface();	
 				 }catch(Exception e) {
 					JOptionPane.showMessageDialog(null, "Id not found", "Task failed", JOptionPane.PLAIN_MESSAGE); 

 					System.out.println(e);
 					 System.exit(0);
 				 }
    	  
    	  
      }}
      
      
      
      
      
      //fooddddddddddddddddddd
      public static void addFood() {
  		
 		 String[] options = {"Add", "Remove"};
 	     
 	      int x = JOptionPane.showOptionDialog(null, "Add/Remove Food",
 	              "Click a button",
 	              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
       if(x==0) {
 	    	  
     	  		
     	  try {
     		  
     		  
     		  String id = JOptionPane.showInputDialog("Enter name"); // user  input password they like
     			
     		  String pass1 = JOptionPane.showInputDialog("Enter Price"); //user inputs there password
   			   Integer pass = Integer.parseInt(pass1);
   			   
  			 Connection con=DriverManager.getConnection(Connection1.url);  

  		
  				Statement stmt=con.createStatement();
  				stmt.executeUpdate("insert into food values('"+id+"',"+pass+")");  
  				
  					
  				adminInterface();
  				 }catch(Exception e) {
  					JOptionPane.showMessageDialog(null, "Invalid entry", "Task failed", JOptionPane.PLAIN_MESSAGE); //display incorrect password message
  					
  					adminInterface();
  					
                    System.out.println(e);
  					 System.exit(0);
  					 System.out.println("Duplicate id");
  				 }
     	  
     	  
     	  			
 	      }
       
       else if(x==1) {
     	  
     	  
     	  		try {
     		  
     		  
     		  String id = JOptionPane.showInputDialog("Enter name"); // user  input password they like
     			
     		  
   			
   			
  			 Connection con=DriverManager.getConnection(Connection1.url);  

  				System.out.println("test2");
  				Statement stmt=con.createStatement();
  				stmt.executeUpdate("delete from food where food.name='"+id+"'");  
  				
  				adminInterface();
  				 }catch(Exception e) {
  					JOptionPane.showMessageDialog(null, "Food not found", "Task failed", JOptionPane.PLAIN_MESSAGE); 

  					System.out.println(e);
  					 System.exit(0);
  				 }
       }}
     	  
     	  		
     	  		
     	  		
     	  		
     	  
    
      
      
 
       public static void addUser() {
     		
   		 String[] options = {"Add", "Remove"};
   	     
   	      int x = JOptionPane.showOptionDialog(null, "Add/Remove User",
   	              "Click a button",
   	              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
         if(x==0) {
   	    	  
       	  		
       	  User.signUp(1);  
       		  
       	  			
   	      }
         
         else if(x==1) {
       	  
       	  
       	  		try {
       		  
       		  
       		  String id = JOptionPane.showInputDialog("Enter id"); // user  input password they like
       			
       		  
     			
     			
    			 Connection con=DriverManager.getConnection(Connection1.url);  

    				System.out.println("test2");
    				Statement stmt=con.createStatement();
    				stmt.executeUpdate("delete from customer where id ='"+id+"'");  
    			
    				adminInterface();
    				 }catch(Exception e) {
    					JOptionPane.showMessageDialog(null, "User not found", "Task failed", JOptionPane.PLAIN_MESSAGE); 
    					
    					
    					System.out.println(e);
    					 System.exit(0);
    				 }
       	  
       	  		
       	  		
       	  		
       	  		
       	  
         }
   
       }
      
      
         public static void orderDetails() {
    		 
 		    
 			try {
 				
 				System.out.println("TESTtttttttttttttttttttt"+l);
 				l++;
 				
 				String[] choices = new String[100];	  
 		  		  
 				
 					
 				  Connection con=DriverManager.getConnection(Connection1.url);  
 		
 			      
 				    Statement stmt=con.createStatement();
 				    
 				    ResultSet rs_food=stmt.executeQuery("select * from orderdetails");
 				  
 				    
 				    
 				    int i=1,k=0;
 				    
 				    while(rs_food.next())
 				    {
// 				    	+Integer.toString(rs_food.getInt(i)
 				    	System.out.println(rs_food.getInt(i+1));
 				    	System.out.println(choices[k]);
 				    	choices[k]= rs_food.getString(i);
 				    	 System.out.println(choices[k]);
 				    	k++;
 				    	
 				    	System.out.println("abc");
 				 
 				    
 				    }
 				    
 				    
 				    String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
 					        "Select order", JOptionPane.QUESTION_MESSAGE, null, // Use
 					                                                                       // default
 					        
 					        // icon
 					        choices, // Array of choices
 					        choices[1]);
 				    
 				    // Initial choice
 				    Integer orderNo = Integer.parseInt(input);
 				    String quantity=null,price=null;
 				
 				    if(input!=null) {
 				        System.out.println("addadadadad"+Integer.toString(JOptionPane.CANCEL_OPTION));
 				    	int q =0;
 				    	String receipt="";
 				    	String[][] orderArray= new String[100][100];
 					    ResultSet rs_food_price=stmt.executeQuery("select * from orderdetails2 where id="+orderNo);
 					    while(rs_food_price.next())
 					    {
 					    	
 					    	System.out.println("jackjsfcsncsfjsfsjfusfk");
 					    	orderArray[q][q]=rs_food_price.getString(2);
 					    	orderArray[q][q+1]=rs_food_price.getString(3);
 					    	orderArray[q][q+2]=rs_food_price.getString(4);
 					    	receipt=receipt+("\n"+rs_food_price.getString(2)+"   "+rs_food_price.getString(3)+"   "+rs_food_price.getString(4));
 					    	System.out.println("\n"+rs_food_price.getString(2)+"   "+rs_food_price.getString(3)+"   "+rs_food_price.getString(4));
 					    	//quantity = JOptionPane.showInputDialog("Price="+rs_food_price.getInt(1)+"  Enter quantity");
 					    	
 					    }
 					    
 					    ResultSet rs_food_price_1=stmt.executeQuery("select amount from orderdetails where id="+orderNo);
 					    while(rs_food_price_1.next()) {
 					    	receipt=receipt+("\n\nTotal:"+rs_food_price_1.getString(1));
 					    	System.out.println(rs_food_price_1.getString(1));
 					    }
 					    System.out.println(receipt+"afyugshf3");
// 					    JOptionPane.showMessageDialog(null,receipt);
 						String[] options = {"OK"};
 					     
 					      int x = JOptionPane.showOptionDialog(null, receipt,
 					              "",
 					              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
 					      
 					      if(x==0) {
 					    	  orderDetails();
 					      }
 					    
 				    	 
 				    }
 				    
 				    else if(input=="2"){
 				    	
 				    	System.out.println("hsbdbfhesbbkbdskvn");
 				    }
 				    
 				    
 				    if(quantity!=null) {
 				    	
 				    	
 				    	selected_items[l][l]=input;
 				    	selected_items[l][l+1]=quantity;
 				    	selected_items[l][l+2]=price;
 				    	selected_items_price[l]=Integer.parseInt(price);
 				    	selected_items_quantity[l] = Integer.parseInt(quantity);
 				    	
 				    	String[] options = {"Finish Order", "Order more"};
 					     
 					      int x = JOptionPane.showOptionDialog(null, "Hello",
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
 					    	JOptionPane.showInputDialog("Your Order has been placed");
 					    	  
 					      }
 					      else if(x==1)
 					    	  
 					    	  orderDetails();
 					    	  
 				    	
 				    	
 				    }
 				    
 				    
 							
 				 } catch(Exception e) {
 					 System.out.println(e);
 					adminInterface();
 					//JOptionPane.showMessageDialog(null, "system error", "Task failed", JOptionPane.PLAIN_MESSAGE); //display incorrect password message
 					System.exit(0);
 					
 				 }
 		
 		    
 		    
 		    
 		  }
 		
   
      
      
      
      
      
      
      
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
