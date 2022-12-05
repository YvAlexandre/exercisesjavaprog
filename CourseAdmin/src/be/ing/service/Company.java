package be.ing.service;

import be.ing.Course;
import be.ing.exception.PriceException;
import be.ing.exception.PriceTooLowException;

public class Company {
    private String name;
    private int companyNumber;
    public Company(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Company(int companyNumber, String name) {
        this(name);
        this.companyNumber = companyNumber;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void printInfo(){
        System.out.println("be.ing.service.Company: " + this.name);
    }

    public String toString() {
        return "be.ing.service.Company :" + getName();
    }

    public double requestPriceOfferForCompanySession(Course c, int numberOfParticipants) throws PriceException {
        CompanySession cs = new CompanySession(c,numberOfParticipants);
        double price = cs.calculatePrice();
        if (price < 2000) throw new PriceTooLowException("Price " + price + " is too low for course " + c.getTitle());
        return price;
    }
}
