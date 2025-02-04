package week1task;

public class User {
	private String name;
	private int age;
	private String phNo;
	
	public User(String name, int age, String phNo) {
		this.name =name;
		this.age = age;
		this.phNo = phNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPhNo() {
		return phNo;
	}
	
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+Integer.hashCode(age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this ==obj) {
			return true;
		}
		if(obj == null || getClass()!=obj.getClass()) {
			return false;
		}
		User user = (User)obj;
		return age == user.age && name.equals(user.name) && phNo.equals(user.phNo);
	}
	
	@Override
	public String toString() {
		return name+" "+age+" "+phNo;
	}
}
