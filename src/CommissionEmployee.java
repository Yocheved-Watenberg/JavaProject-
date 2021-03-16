
public class CommissionEmployee extends Employee {

	float grossSales; //profits from sales per week
	int   commision;  //Commission in percentage that the employee receives from his sales
	
	public CommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision) {
		super(firstName, lastName, id);
		this.grossSales = grossSales;
		this.commision = commision;
	}
	

	public CommissionEmployee() {
		super();
		this.grossSales = 0;
		this.commision = 0;
	}


	public float getGrossSales() {
		return grossSales;
	}


	public void setGrossSales(float grossSales) {
		try
		{
			this.grossSales = grossSales;
		}
		
		catch (NumberFormatException e) 
		{
	    System.err.println("GrosSales must be a float number");
	    }
	}


	public int getCommision() {
		return commision;
	}


	public void setCommision(int commision) {
		try
		{
			this.commision = commision;
		}
		catch (NumberFormatException e) 
		{
	    System.err.println("Comission must be an integer");
	    }
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommissionEmployee other = (CommissionEmployee) obj;
		if (commision != other.commision)
			return false;
		if (Float.floatToIntBits(grossSales) != Float.floatToIntBits(other.grossSales))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "CommissionEmployee [grossSales=" + grossSales + ", commision=" + commision + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", id=" + id + "]";
	}


	@Override
	float earnings() {
		return commision*grossSales/100;
	}

}
