
package baiontapgiuaki_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person{
    
    private float gpa;
    private String major;

    public Student() {
    }

    public Student(float gpa, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    @Override
    public void addPerson() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Enter ID: ");
        this.id = sc.nextLine();
        
        System.out.print("Enter full name: ");
        this.fullName = sc.nextLine();
        
        System.out.print("Enter GPA: ");
        this.gpa = sc.nextFloat();
        sc.nextLine();
        
        System.out.print("Enter major: ");
        this.major = sc.nextLine();
        
        System.out.print("Enter date of birth (dd/MM/yyyy): ");
        String date = sc.nextLine();
        try{
            this.dateOfBirth = sdf.parse(date);
        }catch (ParseException e){
            System.out.println("Ivalid date format. Please enter in dd/MM/yyyy format.");
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
        System.out.println("Id: " + id);
        System.out.println("Full name: " + fullName);
        System.out.println("GPA: " + gpa);
        System.out.println("Date of birth: " + formattedDate);
        System.out.println("Major: " + major+ "\n");
        
    }
    
    
    
            
    
}
