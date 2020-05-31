package horoscop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLDB implements DBInterface{
	public ArrayList<Student> getStudentsFromDB(){
		String url = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			Connection myConn = DriverManager.getConnection(url,"root","12345");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from student");
			
			while(myRs.next()) {
				String id = myRs.getString("NrMatricol");
				String name = myRs.getString("Nume");
				float grade = myRs.getFloat("Medie");
				
				students.add(new Student(id,name,grade));
			}
			//myConn.close();
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		return students;
	}
	
}
