package horoscop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HoroscopePrediction{
	public ArrayList<Student> students;
	
	public HoroscopePrediction(ArrayList<Student> students) {
		this.students = students;
	}
	
	public void getAllStudents(){
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public String generateGradePrediction(String id) {
		int sum = 0;
		int i;
		for(Student st : students) {
			if(id.contentEquals(st.getId())) {
				String name = st.getName();
				
				for(i=0;i<id.length();i++)
					sum+=id.charAt(i);
				
				for(i=0;i<name.length();i++)
					sum+=name.charAt(i);
					
				if(sum%2 == 1){
					return "grade will increase";
				}
				return "grade will decrease";
			}
		}
		return "student not found";
	}
	public int determineStudentsWithLowerGradesInTheFuture() {
		int sum = 0;
		String s = "grade will decrease";
		for(Student st : students) {
			String tempId = st.getId();
			if((st.getGrade() > 8) && s.contentEquals(generateGradePrediction(tempId))) {
				sum++;
			}
		}
		return sum;
	}
	public String willHaveAGoodDayOrNot(String id) {
		for(Student st : students) {
			if(st.getId() == id) {
				Date currentDate = new Date();
				SimpleDateFormat currentday = new SimpleDateFormat("dd");
				String day  = currentday.format(currentDate);
				String name = st.getName();
				if((Integer.parseInt(day) + name.charAt(0)) % 2 == 1) {
					return "good day";
				}
			}
			return "bad day";
		}
		return "student not found!";
	}
}
