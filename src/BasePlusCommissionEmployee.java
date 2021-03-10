
public class BasePlusCommissionEmployee extends CommissionEmployee {
	
float baseSalary;

public BasePlusCommissionEmployee(String firstName, String lastName, int id, float grossSales, int commision,
		float baseSalary) {
	super(firstName, lastName, id, grossSales, commision);
	this.baseSalary = baseSalary;
}

public BasePlusCommissionEmployee() {
	super();
	this.baseSalary=0; 
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
	if (Float.floatToIntBits(baseSalary) != Float.floatToIntBits(other.baseSalary))
		return false;
	return true;
}

@Override
public String toString() {
	return "BasePlusCommissionEmployee [baseSalary=" + baseSalary + ", grossSales=" + grossSales + ", commision="
			+ commision + ", firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
}

public float getBaseSalary() {
	return baseSalary;
}

public void setBaseSalary(float baseSalary) {
	try 
	{
		this.baseSalary = baseSalary;
	}
	catch (NumberFormatException e) 
	{
    System.err.println("baseSalary must be a float number");
	}
}


@Override
float earnings() {
	return baseSalary + commision*grossSales/100;
}

}
