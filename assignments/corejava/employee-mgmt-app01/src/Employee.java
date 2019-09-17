
public class Employee {
	String name;
	int age;
	int id;
	String design;
	String dept;
	String country;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(int id, String name, int age, String design, String dept, String country) {
		super();
		this.id= id;
		this.name = name;
		this.age = age;
		this.design = design;
		this.dept = dept;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [id= " + id + ", name= " + name + ", age= " + age + ", Total designation=" + design + ", department= " + dept + ", country= " + country+ "]\n";
	}
		

}
