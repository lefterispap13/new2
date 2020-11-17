package utils;

import com.lefterisPap.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static database.SchoolDatabase.*;


public class Utilities {

    //this method takes a date with LocalDate format and returns it as a String
    public static String reformatDate(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static LocalDate newDate(String str){
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public static void callScanner(){
        Scanner sc=new Scanner(System.in);
    }

    public static void printStudents(){
        for (Student current:students){
            current.giveBasicStatsForStuds();
        }
    }

    public static void printTrainers() {
        for (Trainer current : trainers) {
            current.showTrainers();
        }
    }

    public static void printAssignments(){
        for (Assignment current:assignments){
            System.out.println(current);
        }
    }

    public static void printCourses(){
        for (StreamPerCourse current:stps){
            current.printCourses();
        }
    }

    public static void  printTrainersPerCourse(){
        for (Trainer current:trainers){
            current.printUserDetails();
        }
    }

    public static void printStudentsPerCourse(){
        for (Student current:students){
            current.showStudentsPerCourse();
        }
    }

    public static void printAssignmentsPerCourse(){
        for (StreamPerCourse current : stps){
            System.out.println("Course title: "+current.getCourse().getTitle()+" , stream : "+
                    current.getStream().getTitle()+ " , type : "+current.getStream().getType()+
                    " ,and assignments: " +current.getStream().getAssign());
        }
    }

    public static void printAssignmentsPerStudent(){
        for (Student i:students) {
            System.out.println("Student :"+i.getLastName()+" "+i.getFirstName() );
            for (AssignmentPerStudent current : i.getIndividualGrades()) {
                System.out.println(current);
            }
        }
    }

    //      ???? list of all assignments per student
    public static void studentsNeedToSubmitAssignments(){
        System.out.println("Students who need to submit one or more assignments are: \n");
        for (Student i:students) { //Ton mathiti olokliro
//            System.out.println("Student :"+i.getLastName()+" "+i.getFirstName() );
            for (AssignmentPerStudent current : i.getIndividualGrades()) {
//                System.out.println(current);
                for (Assignment x: assignments){
                    if (!current.getDeliveryDate().equals(x.getSubDateTime())){
                        System.out.println("Assignment: "+x.getTitle()+" , Student: "+i.getLastName()+" "+i.getFirstName());
                    }
                }

            }
        }
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int userInput;
        int userInput1;
        System.out.println("<=====================================================================>");
        System.out.println("<====================PRIVATE SCHOOL'S DATABASE========================>");
        System.out.println("<=====================================================================>");
        System.out.println(" ");
        System.out.println("Press 0 if you want to terminate the program, 1 if you want to see the existing lists" +
                " and 2 to create new lists: ");
        userInput= sc.nextInt();
        if (userInput==0) {
            System.out.println("Goodbye ..");
        }
        else if (userInput==1) {
            System.out.println("Press 1 for : All the Students");
            System.out.println("Press 2 for : All the Trainers");
            System.out.println("Press 3 for : All the Assignments");
            System.out.println("Press 4 for : All the Courses");
            System.out.println("Press 5 for : All the Students Per Course");
            System.out.println("Press 6 for : All the Trainers Per Course");
            System.out.println("Press 7 for : All the Assignments Per Course");
            System.out.println("Press 8 for : All the Assignments Per Student");
            System.out.println("Press 9 for : All the Students that are enrolled in more than one courses");
            System.out.println("Press 10 for : All the Students who need to submit one or more assignments" +
                    " on the same week");
            int y = sc.nextInt();
            if (y == 1) {
                printStudents();
            }
            else if (y == 2) {
                printTrainers();
            }
            else if (y == 3) {
                printAssignments();
            }
            else if (y == 4) {
                printCourses();
            }
            else if (y == 5) {
                printStudentsPerCourse();
            }
            else if (y == 6) {
                printTrainersPerCourse();
            }
            else if (y == 7) {
                printAssignmentsPerCourse();
            }
            else if (y == 8) {
                printAssignmentsPerStudent();
            }
            else if (y == 9) {
                System.out.println(":)haha:) unlucky!! i don't have one for you");
            }
            else if (y==10 ){
                studentsNeedToSubmitAssignments();
            }
            else
                System.out.println("oops, wrong number!! ");
        }

        else if (userInput==2) {
            ArrayList<Student> students = new ArrayList<>();
            ArrayList<Course> courses = new ArrayList<>();
            ArrayList<Assignment> assignments = new ArrayList<>();
            ArrayList<Stream> streams = new ArrayList<>();
            ArrayList<AssignmentPerStudent> grades = new ArrayList<>();
            ArrayList<Trainer> trainers = new ArrayList<>();
            ArrayList<StreamPerCourse> stps = new ArrayList<>();

            String courseCount;
            int insert;
            do {
                do{   //course

                    System.out.println("At the beginning you need to insert data for the course \n");
                    System.out.println("Please type the name of the course: ");
                    String x = sc.next();
                    System.out.println("Please give me the start date of the course in the form of dd/MM/yyyy");
                    String x1 = sc.next();
                    System.out.println("Please give me the end date of the course in the form of dd/MM/yyyy");
                    String x2 = sc.next();
                    Course course = new Course(x, utils.Utilities.newDate(x1), utils.Utilities.newDate(x2));
                    courses.add(course);
                    System.out.println("If you want to add more courses data press 1");
                    courseCount=sc.next();


                    //assignment
                    System.out.println("\n Now you need to insert data for the assignments \n");
                    System.out.println("Type the title of the assignment: ");
                    String y1 = sc.next();
                    System.out.println("Type the description of this assignment: ");
                    String y2 = sc.next();
                    System.out.println("Type the submission date time in the form of dd/MM/yyyy");
                    String y3 = sc.next();
                    Assignment assignment = new Assignment(y1, y2, utils.Utilities.newDate(y3));
                    assignments.add(assignment);

                    //assignment per student
                    System.out.println("\n Now insert data for the assignments per student: \n");
                    System.out.println("Type the date that student submitted the assignment in the form of dd/MM/yyyy: ");
                    String k1 = sc.next();
                    System.out.println("Type the oral mark of this student for this assignment(use character A,B,C,D or F): ");
                    String k2 = sc.next();
                    System.out.println("Type the total mark of this student for this assignment. Use EX(cellent),HP(ass),PA(ss)," +
                            "LP(ass),FA(il)");
                    String k3 = sc.next();
                    AssignmentPerStudent assignmentPerStudent = new AssignmentPerStudent(assignment, utils.Utilities.newDate(k1),
                            k2, k3);
                    grades.add(assignmentPerStudent);

                    //stream
                    System.out.println("\n Now insert data for the stream: \n");
                    System.out.println(" Type the title of the stream(java,python,c#): ");
                    String p = sc.next();
                    System.out.println(" Type the type of the stream FT(full time) or PT(part time): ");
                    String p1 = sc.next();
                    Stream stream = new Stream(p, p1, assignments);
                    streams.add(stream);

                    //stream per course
                    StreamPerCourse streamPerCourse = new StreamPerCourse(course, stream);
                    stps.add(streamPerCourse);

                    //trainer
                    System.out.println("\n Now insert data for the trainer: \n");
                    System.out.println(" Type the first name of the trainer: ");
                    String t1 = sc.next();
                    System.out.println("Type the last name of the trainer: ");
                    String t2 = sc.next();
                    Trainer trainer = new Trainer(t1, t2, streamPerCourse);
                    trainers.add(trainer);

                    //student
                    System.out.println("\n Now insert data for the student: \n");
                    System.out.println(" Type the first name of the student: ");
                    String s1 = sc.next();
                    System.out.println("Type the last name of the student: ");
                    String s2 = sc.next();
                    System.out.println(" Type the date of birth in the form of dd/MM/yyyy: ");
                    String s3 = sc.next();
                    System.out.println(" Type the tuition fees of this student: ");
                    String s4 = sc.next();
                    Student student = new Student(s1, s2, utils.Utilities.newDate(s3), streamPerCourse, assignments, grades, s4);
                    students.add(student);

                    System.out.println("If you want to insert data for another course press 1" +
                            " or press 2 if you want to continue ");
                    insert = sc.nextInt();

                    do {//print the lists
                        System.out.println("\n Press 0 if you want to exit the program");
                        System.out.println("\n If you want to see the new lists now press: \n");
                        System.out.println("1: for all the students");
                        System.out.println("2: for all the trainers");
                        System.out.println("3: for all the assignments");
                        System.out.println("4: for all the courses");
                        System.out.println("5: for all the students per course");
                        System.out.println("6: for all the trainers per course");
                        System.out.println("7: for all the assignments per course");
                        System.out.println("8: for all the assignments per student");
                        System.out.println("9: for all the students who belong in more than one courses");
                        userInput1 = sc.nextInt();
                        if (userInput1 == 0) {
                            System.out.println(" Goodbye ..");
                        } else if (userInput1 == 1) {
                            printStudents();
                        } else if (userInput1 == 2) {
                            printTrainers();
                        } else if (userInput1 == 3) {
                            printAssignments();
                        } else if (userInput1 == 4) {
                            printCourses();
                        } else if (userInput1 == 5) {
                            printStudentsPerCourse();
                        } else if (userInput1 == 6) {
                            printTrainersPerCourse();
                        } else if (userInput1 == 7) {
                            printAssignmentsPerCourse();
                        } else if (userInput1 == 8) {
                            printAssignmentsPerStudent();
                        } else if (userInput1 == 9) {
                            System.out.println(":)haha:) unlucky!! i don't have one for you");
                        } else {
                            System.out.println("Try again");
                        }
                    }while (userInput1 != 0);
                } while (insert != 1);
            }while (courseCount.equals("1"));
        }
    }
}




