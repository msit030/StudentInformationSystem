import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


public class Main {
	
	
	
	/**
	 * @author Meher
	 * Main Execution File
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Welcome to MSIT Student Information System");
			System.out.print("\n\t Login: ");
			String uid = br.readLine();
			System.out.print("\t Password: ");
			String pwd = br.readLine();
			
			if(uid.contains("ST") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Student Home Page");
				Student crrntStudnt = (Student)getPerson(uid,pwd,"student");
				
				if(crrntStudnt == null){
					System.out.println("\nInvalid Student");
					return;
				}
				System.out.println("Greetings, "+crrntStudnt.firstName);
				
				
			}
			else if(uid.contains("PR") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Professor Home Page");
				Professor crrntProf = (Professor)getPerson(uid, pwd, "professor");
				
				if(crrntProf == null){
					System.out.println("\nInvalid Professor");
					return;
				}
				System.out.println("Greetings, XYZ");
				
				
			}
			else if(uid.contains("Admin") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Principal Home Page");
				Principal principal = new Principal();
				System.out.println("Greetings, Princi");
				
			}
			else if(uid.contains("Exam") && pwd.contains("SI")){
				System.out.println("\n\tWelcome to Exam Branch Home Page");
				ExamBranch exambranch = new ExamBranch();
				System.out.println("Greetings, Exam Branch");
				
			}
			
			
			br.close();
		}
		catch(Exception e){
			System.out.println("Error in Running main Software");
		}

	}

	/**
	 * @author Meher
	 * Get Student from Data Helper.
	 * @param uid
	 * @param pwd
	 * @return
	 */
	private static Object getPerson(String uid, String pwd, String person) {
		
		DataHelper dh = new DataHelper();
		
		if(person.equalsIgnoreCase("student")){
				List<Student> students = dh.list_Student;
				for(Student s : students){
						if(s.studentID.equalsIgnoreCase(uid) && s.password.equalsIgnoreCase(pwd))
							return s;
				}
		}
		else if(person.equalsIgnoreCase("professor")){
			List<Professor> prof = dh.list_Professor;
			for(Professor p : prof){
				if(p.professorID.equalsIgnoreCase(uid) && p.password.equalsIgnoreCase(pwd))
					return p;
			}
		}
		return null;
	}

}
