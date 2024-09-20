
package baiontapgiuaki_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teacher extends Person{
    private String department;
    private String teachingSubject;

    public Teacher() {
    }

    public Teacher(String department, String teachingSubject, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Enter ID: ");
        this.id = sc.nextLine();
        
        System.out.print("Enter full name: ");
        this.fullName = fullName;
        
        System.out.print("Enter department: ");
        this.department = sc.nextLine();
        
        System.out.print("Enter teachingSubject: ");
        this.teachingSubject = sc.nextLine();
        
        System.out.print("Date of birth(dd/MM/yyyy): ");
        String date = sc.nextLine();
        try{
            this.dateOfBirth = sdf.parse(date);
        } catch (ParseException e){
            System.out.println("Invalid date format. Pease again inter dd/MM/yyyy format");
            return;
        }
                
   
    }

    @Override
    public void updatePerson(String id) {
        this.id = id;
    }

    @Override
    public void displayInfor() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(dateOfBirth);
        System.out.println("ID: " + id);
        System.out.println("Full name: " + fullName);
        System.out.println("Date of birth: " + formattedDate);
        System.out.println("Department: " + department);
        System.out.println("Teaching subject: " + teachingSubject);
    }
    
    

    
    
    
    
}
