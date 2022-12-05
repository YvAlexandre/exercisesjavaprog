package be.ing.service;

import be.ing.Course;
import be.ing.Person;
import be.ing.exception.PriceTooHighException;

import java.time.LocalDate;

public class CompanySession extends Session {
private int participants;


    public CompanySession(Course course, LocalDate date, Company location, Person instructor, int participants) {
        super(course, date, location, instructor);
        this.participants = participants;
    }

    public CompanySession(Course course, int numberOfParticipants) {
        super(course);
        this.participants = numberOfParticipants;
    }


    @Override
    public String getOrganizer() {
        return null;
    }

    public void printInfo(){
        System.out.println("This session is offered to you by " + getLocation().getName() + ". There will be " + getParticipants() + " participants.");
    }

    @Override
    public double calculatePrice() throws PriceTooHighException {
        System.out.println("The price for the be.ing.service.Company session is 400.00");
        double totalPrice = this.getCourse().calculateTotalPrice()*this.getParticipants();
        if (totalPrice>4500) throw new PriceTooHighException(totalPrice + " is too expensive");
        return totalPrice;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }


}
