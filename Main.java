// Employee Organization and Lookup program
// written by Francisco J Segarra Jr

import java.io.*;
import java.util.*;

public class Main 
{
			
			// ArrayLists for the different types of Employees
   private static	ArrayList<HourlyEmployee> he = new ArrayList<>();
   private	static ArrayList<SalariedEmployee> se = new ArrayList<>();
   private	static ArrayList<Supervisor> sup = new ArrayList <>();

   public static void main(String[] args) throws IOException
   {
   	// create a scanner for user input
      Scanner kb = new Scanner(System.in);
   	
   	// Scanner for reading in text file
      File inFile = new File("employeeData.txt");
      Scanner inputFile = new Scanner(inFile);
   	
   	// declare variables
      String title, name, address; 
      char choice1;
      int employID, bossID, startYear, money2, employType;
      double money1;
   	
   	// the loop inserting the data from a text file to the the ArrayList
      while (inputFile.hasNextLine())
      {
         String line = inputFile.nextLine();
         Scanner s = new Scanner(line).useDelimiter(";");	// splits elements with a semicolon
              
         title = s.next();
         name = s.next();
         address = s.next();
         employID = s.nextInt();
         bossID = s.nextInt();
         startYear = s.nextInt();
         money1 = s.nextDouble();
                
         if (title.equals("Hourly"))			// places data in Hourly Employee ArrayList
         {
            money2 = s.nextInt();
            he.add( new HourlyEmployee (title, name, address, employID, bossID, startYear, money1, money2)); 
         }
            
         if (title.equals("Salaried"))			// places data in Salaried Employee ArrayList
         {
            se.add( new SalariedEmployee (title, name, address, employID, bossID, startYear, money1));  
         }
          
         if (title.equals("Supervisor"))		// places data in Supervisor ArrayList
         {
            money2 = s.nextInt();
            sup.add( new Supervisor (title, name, address, employID, bossID, startYear, money1, money2)); 
         }   		         
      } // end while Loop
   	
      inputFile.close();		// closing the file
   	
      boolean done = false;
   	
      while (!done)
      {
      	// Header for choosing if user wants all titled or single employee
         choice1 = allOrOne() ;
      	
      	// Header for choosing between the types of employees
         if (choice1 == 'A' || choice1 ==  'a')
         {
            employType = employType();
         
         	// printing out all the information about the hourly employees
            if (employType == 1)
            {
               System.out.println("\n\t     Name\t  ID      Gross     Employed");
               System.out.println("\t\t\t\t  Weekly    Since");
               System.out.println("\t\t\t\t  Pay\n");
            	
               for(int i = 0; i < he.size(); i++)
               {
                  HourlyEmployee e = he.get(i);
               	
                  String n = e.getName();
                  int eID = e.getEmployeeID();
                  double wp = e.getGrossWeeklyPay();
                  int sy = e.getYear();
               	
                  System.out.printf("%20s    %6d   %7.2f    %4d\n", n, eID, wp, sy);
               	
               } // end for loop
            } // end all hourly employee info
            
            // printing out all the information about the Salaried employees
            else if (employType == 2)
            {
               System.out.println("\n\t     Name\t  ID      Gross     Employed");
               System.out.println("\t\t\t\t  Weekly    Since");
               System.out.println("\t\t\t\t  Pay\n");
            	
               for(int i = 0; i < se.size(); i++)
               {
                  SalariedEmployee e = se.get(i);
               	
                  String n = e.getName();
                  int eID = e.getEmployeeID();
                  double wp = e.getGrossWeeklyPay();
                  int sy = e.getYear();		
               	
                  System.out.printf("%20s    %6d   %7.2f    %4d\n", n, eID, wp, sy);
               	
               } // end for loop
            } // end all salaried employee info
            
            
            else if (employType == 3)
            {
            	
               System.out.println("\n\t     Name\t  ID      Gross     Employed        Direct Reports");
               System.out.println("\t\t\t\t  Weekly    Since");
               System.out.println("\t\t\t\t  Pay\n");
            	
            	// searching for the supervisors
               for(int i = 0; i < sup.size(); i++)
               {
                  Supervisor e = sup.get(i);			
               	
                  String subID = "";					// Initializing String for the subordinates IDs 
                  String n = e.getName();				// getting the supervisors name
                  int eID = e.getEmployeeID();		// getting the supervisors employee ID
                  double wp = e.getGrossWeeklyPay();	// getting the supervisors weekly pay
                  int sy = e.getYear();				// getting the year the supervisors started working
               	
               	// searching for the subordinates of the supervisors
               	// in each of the ArrayList and if a match is found it
               	// is added to the subID variable for each of the supervisors 
               	
               	// Subordinate supervisor search
                  for(int a = 0; a < sup.size(); a++)
                  {
                     Supervisor em = sup.get(a);
                     int bID = em.getBossID();
                  	
                     if (eID == bID)
                     {	
                        subID = subID + " " + Integer.toString(em.getEmployeeID());
                     }
                  	
                  } // end for loop
               	
               	// hourly employee search
                  for(int b = 0; b < he.size(); b++)
                  {
                     HourlyEmployee emp = he.get(b);
                     int bID = emp.getBossID();
                  	
                     if (eID == bID)
                     {	
                        subID = subID + " " + Integer.toString(emp.getEmployeeID());
                     }
                  	
                  } // end for loop
               	
               	// salaried employee search
                  for(int c = 0; c < se.size(); c++)
                  {
                     SalariedEmployee empl = se.get(c);
                     int bID = empl.getBossID();
                  	
                     if (eID == bID)
                     {	
                        subID = subID + " " + Integer.toString(empl.getEmployeeID());
                     }
                  	
                  } // end for loop
               	
                  System.out.printf("%20s    %6d   %7.2f    %4d         %-28s\n", n, eID, wp, sy, subID);
               	
               } // end the BIG for loop
            	
            } // end all supervisor info
         	
         } // end if choice is A
      		
         if (choice1 == 'B' || choice1 == 'b')
         {
            int val = idLookUp();
         	
            if (val == -1)
               System.out.println("   Sorry, no employee with that ID was found.\n");
         	
         } // end if choice is B
      		
         if (choice1 == 'X' || choice1 == 'x')
         {
            done = true;
         }
      	
      } // end while
   	
   } // end main
	
	
	
	// method asking user if they are searching for one or all employees in a category
   public static char allOrOne()
   {
      Scanner a = new Scanner(System.in);
   	
      System.out.println("\tEmployee Lookup Program\n");
      System.out.println("A) Find all employee with a given title\n");
      System.out.println("B) Find a single employee\n");
      System.out.println("X) Exit the program");
      System.out.print("      Enter your choice: ");
      String choice = a.next();
   	
      char choiceChar = choice.charAt(0);
   	
      return choiceChar;
   } // end method
	
	
	
	// method for finding out which type of of employee to look up
   public static int employType()
   {
      Scanner b = new Scanner(System.in);
   	
      System.out.println("\n1) Hourly Employee\n");
      System.out.println("2) Salaried Employee\n");
      System.out.println("3) Supervisory Employee");
      System.out.print("      Enter 1, 2, or 3: ");
      int choice = b.nextInt();
   	
      return choice;
   } // end method
	
   public static int idLookUp()
   {
      Scanner c = new Scanner(System.in);
   	
      int retVal = -1;
   	
      System.out.print("\nEnter the ID of the employee: ");
      int employID = c.nextInt();
   	
   	// checking the supervisor ArrayList for the employee ID
      for(int i = 0; i < sup.size(); i++)
      {
         Supervisor e = sup.get(i);
      	
         String n = e.getName();
         int eID = e.getEmployeeID();
         int sy = e.getYear();
      	
         if (employID == eID)
         {
            System.out.print("   " + n + "   " + eID + "  Supervisor, employed since " + sy + "\n\n");
            retVal = 5;
         }
      } // end for loop	
   	
   	// checking the hourly employee ArrayList for employee ID
      for(int i = 0; i < he.size(); i++)
      {
         HourlyEmployee e = he.get(i);
      	
         String n = e.getName();
         int eID = e.getEmployeeID();
         int sy = e.getYear();
      		
         if (employID == eID)
         {
            System.out.print("   " + n + "   " + eID + "  Hourly Employee, employed since " + sy + "\n\n");
            retVal = 5;
         }
      } //end for loop
   	
   	// checking salaried employee ArrayList for employee ID
      for(int i = 0; i < se.size(); i++)
      {
         SalariedEmployee e = se.get(i);
      		
         String n = e.getName();
         int eID = e.getEmployeeID();
         int sy = e.getYear();
      		
         if (employID == eID)
         {
            System.out.print("   " + n + "   " + eID + "  Salaried Employee, employed since " + sy + "\n\n");
            retVal = 5;
         }
      } //end for loop
      return retVal;
   } // end method
	
} // end class
