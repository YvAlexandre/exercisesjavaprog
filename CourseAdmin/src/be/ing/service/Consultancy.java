package be.ing.service;

public class Consultancy extends Service{
    @Override
    public double calculatePrice() {
        System.out.println("The price for the be.ing.service.Consultancy is 1000.00");
        return 1000.00;
    }

    @Override
    public void printInfo() {

    }
}
