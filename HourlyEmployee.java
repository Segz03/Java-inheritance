
// written by Francisco J Segarra Jr


public class HourlyEmployee extends Employee
{
   private double hourlyRate;
   private int hoursWorked;
	
   public HourlyEmployee(String t, String n, String a, int e, int b, int y, double hr, int hw) 
   {
      super(t, n, a, e, b, y);			// passing the value to the parent
   
   	// the private data type specific to hourly employee
      hourlyRate = hr;
      hoursWorked = hw;
   		
   } // end Constructor
	
	
	
	// setter methods for additional data specific to hourly employee
   public void setHourlyRate(double hr)
   {
      hourlyRate = hr;
   } // end method
	
   public void setHoursWorked(int hw)
   {
      hoursWorked = hw;
   } // end method
	
	
	
	// getter methods for additional data specific to hourly employee
   public double getHourlyRate()
   {
      return hourlyRate;
   } // end method
	
   public int getHoursWorked()
   {
      return hoursWorked;
   } // end method
	
	
	
	// method for hourly weekly pay
   public double getGrossWeeklyPay()
   {
   	// weekly pay for a hourly employee
      double pay = getHourlyRate() * getHoursWorked();
   	
      return pay;
   } // end Method
	
   public String toString()
   {
      String msg = hourlyRate + ", "+ hoursWorked;
      return msg;
   } // end toString
	
} // end class
