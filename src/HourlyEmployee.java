
public class HourlyEmployee extends Employee  {

	int hours;  //hours that the employee works every week  
	float wage; //salary per hour 
	
	
	public HourlyEmployee(String firstName, String lastName, int id, int hours, float wage) {
		super(firstName, lastName, id);
		this.hours = hours;
		this.wage = wage;
	}


	public HourlyEmployee() {
		super();
		this.hours = 0;
		this.wage = 0;
	}


	public int getHours() {
		return hours;
	}


	public void setHours(int hours) {
		try
		{
			this.hours = hours;
		}
		 catch (NumberFormatException e) 
		{
	     System.err.println("Hours must be integers");
	    }
	}

	
	public float getWage() {
	
		return wage;
	}


	public void setWage(float wage) {
		try
		{
			this.wage = wage;
		}
		 catch (NumberFormatException e) 
		{
	    System.err.println("Wage must be a float number");
	    }
	}


	@Override
	public String toString() {
		return "HourlyEmployee [hours=" + hours + ", wage=" + wage + ", firstName=" + firstName + ", lastName="
				+ lastName + ", id=" + id + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HourlyEmployee other = (HourlyEmployee) obj;
		if (hours != other.hours)
			return false;
		if (Float.floatToIntBits(wage) != Float.floatToIntBits(other.wage))
			return false;
		return true;
	}


	@Override
	float earnings() {
		return hours*wage;
	}
}
