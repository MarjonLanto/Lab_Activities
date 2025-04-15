import java.util.Scanner;
public class Person {

    private String name;
    private int id;

    //Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //Method to display information
    public void displayInfo() { 
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
    
    public class SchoolTest { 

        public static void main(String[] args) { 
            Scanner s = new Scanner(System.in);
            
            //Input for student, teacher, and staff details
            System.out.println("-------------------------");
            System.out.println("Enter Student Details:");
            System.out.print("Name: ");
            String sName = s.nextLine();
            System.out.print("ID: ");
            int sId = s.nextInt();
            s.nextLine();  
            System.out.print("Grade Level: ");
            String gradeLevel = s.nextLine();
            System.out.println("-------------------------");
            
            System.out.println("-------------------------");
            System.out.println("Enter Teacher Details:");
            System.out.print("Name: ");
            String tName = s.nextLine();
            System.out.print("ID: ");
            int tId = s.nextInt();
            s.nextLine();  
            System.out.print("Subject: ");
            String subject = s.nextLine();
            System.out.println("-------------------------");
    
            System.out.println("-------------------------");
            System.out.println("Enter Staff Details:");
            System.out.print("Name: ");
            String stName = s.nextLine();
            System.out.print("ID: ");
            int stId = s.nextInt();
            s.nextLine();
            System.out.print("Department: ");
            String department = s.nextLine();
            System.out.println("-------------------------");
    
            //objects
            Person student = new Student(sName, sId, gradeLevel);
            Person teacher = new Teacher(tName, tId, subject);
            Person staff = new Staff(stName, stId, department);
    
            //display input
            System.out.println("-------------------------");
            System.out.println("\nStudent Details:");
            student.displayInfo();

            System.out.println("\nTeacher Details:");
            teacher.displayInfo();

            System.out.println("\nStaff Details:");
            staff.displayInfo();
            System.out.println("");
            System.out.println("-------------------------");
    
    
        }
    }
}



