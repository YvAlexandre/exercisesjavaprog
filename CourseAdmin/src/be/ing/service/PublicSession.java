package be.ing.service;

import be.ing.Course;
import be.ing.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicSession extends Session {
    public final static Company companyABIS = new Company("ABIS");

    private List<CourseParticipant> enrolments = new ArrayList<>();

    @Override
    public String getOrganizer() {
        return null;
    }

    public PublicSession(Course course, LocalDate date, Company location, Person instructor) {
        super(course, date, location, instructor);
    }

    public List<CourseParticipant> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<CourseParticipant> enrolments) {
        this.enrolments = enrolments;
    }

    public void addEnrolment(CourseParticipant cp){
        enrolments.add(cp);
        System.out.println(cp + " was added as participant.");
    }

    public void addEnrolments(CourseParticipant... cps){
        for (CourseParticipant cp:cps)  addEnrolment(cp);
    }

    public void cancelEnrolment(CourseParticipant cp){
        enrolments.remove(cp);
        System.out.println(cp + " cancelled " +  cp + " enrolment.");
    }
    @Override
    public void printInfo() {
        System.out.println("This " + getCourse().getTitle() + " will start on " + getDate() + ".  It will take place at " + getLocation().getName() + ". Your instructor is " + getInstructor().getFirstName() + " of " + getInstructor().getCompany().getName());
    }
    @Override
    public double calculatePrice() {
        System.out.println("The price for the Public session is 300.00");
        return 300.00;
    }

    public Company getCompanyABIS() {
        return companyABIS;
    }


}
