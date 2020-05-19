
// written by Francisco J Segarra Jr


public class Supervisor extends SalariedEmployee
{
   private int annualBonus;
	
   public Supervisor(String t, String n, String a, int e, int b, int y, double as, int ab) 
   {
      super(t, n, a, e, b, y, as);			// passing the value to the parent
   
   	// the private data type specific to a salaried employee
      annualBonus = ab;
   		
   } // end Constructor
	
	
	
	// setter method for additional data specific to supervisor
   public void setAnnualBonus(int ab)
   {
      annualBonus = ab;
   } // end method
	
	
	
	// getter method for additional data specific to supervisor
   public int getAnnualBonus()
   {
      return annualBonus;
   } // end method
	
	
	
	// method for supervisors weekly pay
   public double getGrossWeeklyPay()
   {
   	// weekly pay for a supervisor
      double pay = (getAnnualSalary() / 52) + (getAnnualBonus() / 52);
   		
      return pay;		
   } // end Method
	
   public String toString()
   {
      String msg = Integer.toString(annualBonus);
      return msg;
   }
	
} // end class
