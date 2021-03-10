public class Payroll // checks the integrity of all the class
{

	public static void main(String[] args) 
	{
		Employee[] anArray = new Employee[3];  
		anArray[0] = new HourlyEmployee("Avi","Zerbib",12345,35,50);
		anArray[1]= new CommissionEmployee("Jacob", "Cohen", 56789, 3000, 25);
		anArray[2]= new BasePlusCommissionEmployee("Israel", "Levy", 98765,2234,10,8000); 
		
		for (Employee i: anArray) 
		{
			System.out.println(i.toString());
			if (i instanceof BasePlusCommissionEmployee)
			{
				System.out.println("The salary of " + i.lastName + " " + i.firstName + " is " +  Math.floor((i.earnings()*1.1)*100)/100);
			}
			else 
			{
				System.out.println("The salary of  " + i.lastName + " " + i.firstName + " is " +  Math.floor((i.earnings())*100)/100);	//in order to keep only two numbers after comma
					
		
			}
		}
		
	}
}

