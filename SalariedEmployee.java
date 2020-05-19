
// written by Francisco J Segarra Jr


public class SalariedEmployee extends Employee
{
   private double annualSalary;
	
   public SalariedEmployee(String t, String n, String a, int e, int b, int y, double as) 
   {
      super(t, n, a, e, b, y);			// passing the value to the parent
   
   	// the private data type specific to a salaried employee
      annualSalary = as;
   		
   } // end Constructor
	
	
	
	// setter method for additional data specific to salary employee
   public void setAnnualSalary(double as)
   {
      annualSalary = as;
   } // end method
	
	
	
	// getter method for additional data specific to salary employee 
   public double getAnnualSalary()
   {
      return annualSalary;
   } // end method
	
	
	
	// method for salaried employee weekly pay
   public double getGrossWeeklyPay()
   {
   	// weekly pay for a salary employee
      double pay = getAnnualSalary() / 52;
   	
      return pay;
   } // end Method
	
   public String toString()
   {
   	
      String msg = Double.toString(annualSalary);
      return msg;
   }
	
} // end class
