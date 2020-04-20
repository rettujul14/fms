package fms;



import javax.swing.JOptionPane;

public class Fmsinterface
{
	

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		String[] options = {"Customer", "Employee", "Admin"};
	     
	      int x = JOptionPane.showOptionDialog(null, "Food Delivery ","",
	              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	      if(x==0) {
	    	  
	    	  User user = new User();
	      }
	      else if(x==1) {
	    	  
	    	  Employee.userInterface();
	      }
	      else if(x==2) {
	    	  Admin admin = new Admin();
	      }
	      
	      
	}
	
}
		
	