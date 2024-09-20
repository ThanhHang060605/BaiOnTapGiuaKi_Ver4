package baiontapgiuaki_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) throws ParseException {
        PersonList personList = new PersonList();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n******Choose an option********");
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person by id");
            System.out.println("4. Delete person by id");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. find teacher by department");
            System.out.println("8. Exit");
            System.out.println("-------Enter number---------");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                         System.out.print("Enter ID: ");
                        String studentId = sc.nextLine();

                        System.out.print("Enter full name: ");
                        String studentName = sc.nextLine();

                        System.out.print("Enter date of birth (dd/MM/yyyy): ");
                        String date = sc.nextLine();
                        Date dateOfBirthStudent = sdf.parse(date);

                        System.out.print("Enter GPA: ");
                        float gpa = sc.nextFloat();
                        sc.nextLine();  

                        System.out.print("Enter major: ");
                        String major = sc.nextLine();

                        Student student = new Student(gpa, major, studentId, studentName, dateOfBirthStudent);
                        personList.addStudent(student);
                        System.out.println("Student added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        String ID = sc.nextLine();

                        System.out.print("Enter full name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter teaching subject: ");
                        String teachingSubject = sc.nextLine();

                        System.out.print("Enter date of birth(dd/MM/yyyy):");
                        String dob = sc.nextLine();
                        Date dateOfBirth2 = sdf.parse(dob);
                        
                        Teacher teacher = new Teacher(department, teachingSubject, ID, name, dateOfBirth2);
                        personList.addteacher(teacher);
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        String iD = sc.nextLine();
                        Person personToUpdate = personList.findPersonByID(iD);

                        if (personToUpdate != null) {
                            System.out.print("ID: " + iD+"\n");
                            System.out.print("Enter new full name: ");
                            String newName = sc.nextLine();
                            personToUpdate.setFullName(newName);

                            System.out.print("Enter new date of birth: ");
                            String newDate = sc.nextLine();
                            Date date2 = sdf.parse(newDate);

                            System.out.println("Up date person suscessfully\n");
                        } else {
                            System.out.println("Person not found");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        String delete = sc.nextLine();
                        personList.deletePersonByID(delete);
                        System.out.println("Delete person by ID suscessfully");
                        break;
                    case 5:
                        System.out.println("Display all students and teacher");
                        personList.displayEveryone();
                        break;
                    case 6:
                        Student topStudent = personList.findTopStudent();
                        if (topStudent != null) {
                            System.out.println("Student with the highest GPA");
                            topStudent.displayInfor();
                        } else {
                            System.out.println("No student in list");
                        }
                        break;

                    case 7:
                        System.out.print("Enter depatrment: ");
                        String departmentName = sc.nextLine();
                        Teacher findTeacher = personList.findTeacherByDepartment(departmentName);
                        if (findTeacher != null) {
                            System.out.println("Teacher found in department: " + departmentName);
                            findTeacher.displayInfor();
                        } else {
                            System.out.println("No teacher found in the department!\n");
                        }
                        break;

                    case 8:
                        exit = true;
                        System.out.println("The end");
                        break;
                    default:
                        System.out.println("Invalid choice. Again Please ");
                        break;
                }

            } catch (ParseException ex){
                System.out.println("Invalid choice. Again Please");
              
            }

        }
        sc.close();
    }

}
