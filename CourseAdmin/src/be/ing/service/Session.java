package be.ing.service;

import be.ing.Course;
import be.ing.Person;
import be.ing.exception.PriceTooHighException;
import be.ing.utilities.DateUtils;

import java.time.LocalDate;

public abstract class Session extends Service {
    private Course course;
    private LocalDate date;
    private Company location;
    private Person instructor;

    public abstract String getOrganizer();

    public Session(Course course, LocalDate date, Company location,
                   Person instructor) {
        this.course = course;
        this.date = date;
        this.location = location;
        setInstructor(instructor);
    }

    public Session() {
    }

    public Session(Course course){
        this.course=course;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Company getLocation() {
        return location;
    }
    public void setLocation(Company location) {
        this.location = location;
    }

    public Person getInstructor() {
        return instructor;
    }
    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public void printInfo() {
        System.out.println("This " + getCourse().getTitle() + " will start on " + DateUtils.format(date) + ".  It will take place at " + getLocation().getName() + ". Your instructor is " + getInstructor().getFirstName());
    }

    @Override
    protected double calculatePrice() throws PriceTooHighException {
        return 0;
    }
}
