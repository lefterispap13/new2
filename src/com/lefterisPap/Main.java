package com.lefterisPap;

import database.SchoolDatabase;
import utils.Utilities;

import java.util.ArrayList;

import static database.SchoolDatabase.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        utils.Utilities.mainMenu();

//        for (Student current:students){
//            for (AssignmentPerStudent i:current.getPersAssignments()){
//        }




//        ArrayList<Student> students= SchoolDatabase.students;
//        ArrayList<Trainer> trainers=SchoolDatabase.trainers;
//        ArrayList<Assignment> assignments=SchoolDatabase.assignments;

//        Scanner input=new Scanner(System.in);
//
//        System.out.println("dose to course name ");
//        String name = input.next();
//        System.out.println("dose to course startDate ");
//        String startDate = input.next();
//        System.out.println("dose to course endDate ");
//        String endDate = input.next();
//        Course course = new Course(name, Utilities.newDate(startDate), Utilities.newDate(endDate) );
//        courses.add(course);

        //Assigmnets

        //Streams

        //StreamsPerCourse

        //Students



        // ??list of all students
//        for (Student current:students){
//            current.giveBasicStatsForStuds();
//        }

        //?? list of all trainers
//        for (Trainer current:trainers){
//            current.showTrainers();
//        }

        //???list of all courses
//        for (StreamPerCourse current:stps){
//            current.printCourses();
//        }

         //??list of all assignments
//        for (Assignment current:assignments){
//            System.out.println(current);
//        }

        //??? list of all the students per course
//        for (Student current:students){
//            current.showStudentsPerCourse();
//        }

        //??list of all trainers per course
//        for (Trainer current:trainers){
//            current.printUserDetails();
//        }


//          ???list of all assignments per course
//        for (StreamPerCourse current : stps){
//            System.out.println("Course title: "+current.getCourse().getTitle()+" , stream : "+current.getStream().getTitle()+ " , type : "+current.getStream().getType()+ " ,and assignments: " +current.getStream().getAssign());
//        }


//      ???? list of all assignments per student
//        System.out.println("Students that submitted the assignments on the same day that submission date expires \n");
//        for (Student i:students) { //Ton mathiti olokliro
////            System.out.println("Student :"+i.getLastName()+" "+i.getFirstName() );
//            for (AssignmentPerStudent current : i.getIndividualGrades()) {
////                System.out.println(current);
//                for (Assignment x: assignments){
//                    if (current.getDeliveryDate().equals(x.getSubDateTime())){
//                        System.out.println("Assignment: "+x.getTitle()+" , Student: "+i.getLastName()+" "+i.getFirstName());
//                    }
//                }
//
//            }
//        }




        //??? list of students of more than one courses
//        for (Student i:students){
//            String s1=i.getLastName();
//            String s2=i.getFirstName();
//            String s3=utils.Utilities.reformatDate(i.getDateOfBirth());
//            String s4=i.getPersonalCourse().getCourse().getTitle();
//            String s5=i.getPersonalCourse().getStream().getTitle();
//            String s6=i.getPersonalCourse().getStream().getType();
//            for
//        }


    }
}

