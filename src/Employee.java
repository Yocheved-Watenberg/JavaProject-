/**
 * 
 */

/**
 * @author Avigail Amar and Yocheved Watenberg
 *
 */
//import java.util.*;
public abstract class Employee {

	/**
	 * @param args
	 */
	String firstName;
	String lastName;
	int id; 
	
	public Employee() {
		super();
		this.firstName = "plony";
		this.lastName = "almony";
		this.id = 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		try
		{
			this.firstName = firstName;
		}
		catch(IllegalArgumentException e) {
			 System.err.println("FirstName must be a string");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		try
		{
			this.lastName = lastName;
		}
		catch(IllegalArgumentException e) 
		{
			 System.err.println("LastName must be a string");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		try
		{
			this.id = id;
		}
		catch(IllegalArgumentException e) {
			 System.err.println("Id must be an integer");
		}
	}

	public Employee(String firstName, String lastName, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	abstract float earnings(); //returns the earnings of the employee
}
