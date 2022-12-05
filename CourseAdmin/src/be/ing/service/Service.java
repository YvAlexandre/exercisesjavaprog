package be.ing.service;

import be.ing.exception.PriceTooHighException;

public abstract class Service {
    protected abstract double calculatePrice() throws PriceTooHighException;
    public abstract void printInfo();

}
