package fms;

import java.sql.*;

import javax.swing.JOptionPane;

public class Employee
{

	static String[][] selected_items = new String[10][10];
	static int l=-1;
	static String contact1=null;
	static int[] selected_items_price = new int[10];
	static int[] selected_items_quantity = new int[10];
	/**
	 * @param args the command line arguments
	 */
	 
	
//		InputDialogWithDropdownListbox();
		
	
	
	
	public static void userInterface() {
		
		 String[] options = {"SIgnIn","Home"};
	     
	      int x = JOptionPane.showOptionDialog(null, "Hello",
	              "Employee",
	              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	      
	      if(x==0) 
	    	  signIn();
	      else if(x==1)
	    	  Fmsinterface.main(null);

	    	  
	    	  
	}
	
	
	
	public static void signIn() {
		
		
		try {
	  		  
			 System.out.println("TEST6");
	  		  String id = JOptionPane.showInputDialog("Enter id"); 
	  
	  		  contact1 = JOptionPane.showInputDialog("Enter password");
	  		  
	  		 
				
			  Connection con=DriverManager.getConnection(Connection1.url);  
	
		      
			    Statement stmt=con.createStatement();
			    System.out.println("TEST7");
			    ResultSet rs_user=stmt.executeQuery("select * from employee where id='"+id+"' AND pass="+contact1+"");
				
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
					orderDetails();
				}
			    }
			    
			    }
			    
						
			 } catch(Exception e) {
				 System.out.println(e);
			userInterface(); //display incorrect password message
				
				
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
//				    	+Integer.toString(rs_food.getInt(i)
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
//					    JOptionPane.showMessageDialog(null,receipt);
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
					 Fmsinterface.main(null);
					//JOptionPane.showMessageDialog(null, "system error", "Task failed", JOptionPane.PLAIN_MESSAGE); //display incorrect password message
					System.exit(0);
					
				 }
		
		    
		    
		    
		  }
		
	
	
	
}
