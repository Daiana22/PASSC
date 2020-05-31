package horoscop;

public class Student {
	private String id;
	private String name;
	private float grade;
	public Student(String id,String name, float grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public String toString() {
		return this.id + " " + this.name + " " + this.grade;
	}
}
