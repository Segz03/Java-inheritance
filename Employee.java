
// written by Francisco J Segarra Jr


public abstract class Employee 
{
	// private data
   private String title, name, address; 
   private int employeeID, bossID, startYear;
	
   public Employee(String t, String n, String a, int e, int b, int y)
   {
      title = t;
      name = n;
      address = a;
      employeeID = e;
      bossID = b;
      startYear = y;
   
   } // end Constructor
	
	
	
	// the setter methods for the private data in the constructors
	
   public void setTitle(String t)
   {
      title = t;
   }
	
   public void setName(String n)
   {
      name = n;
   } // end method
	
   public void setAddress(String a)
   {
      address = a;
   } // end method
	
   public void setEmployeeID(int e)
   {
      employeeID = e;
   } // end method
	
   public void setBossID(int b)
   {
      bossID = b;
   } // end method
	
   public void setYear(int y)
   {
      startYear = y;
   } // end method
	
	
	
	// the getter methods for the private data in the constructors
   public String getTitle()
   {
      return title;
   }
	
   public String getName()
   {
      return name;
   } // end method
	
   public String getAddress()
   {
      return address;
   } // end method
	
   public int getEmployeeID()
   {
      return employeeID;
   } // end method
	
   public int getBossID()
   {
      return bossID;
   } // end method
	
   public int getYear()
   {
      return startYear;
   } // end method
	
	
	
	// abstract get weekly pay method
   public abstract double getGrossWeeklyPay();		// end Method
	
	
	
   public String toString()
   {
      String msg = title + ", "+ name +", " + address + ", " + employeeID + ", " + bossID + ", " + startYear;
      return msg;
   } // end toString
	
} // end class
