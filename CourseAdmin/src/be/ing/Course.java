package be.ing;

public class Course {
    private String title;
    private int numberOfDays;
    private double pricePerDay;


    Course(String title, int numberOfDays, double pricePerDay) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
    }


    public String getTitle() {
        return title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
    public void setDays(int days) {
        this.numberOfDays = days;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void printInfo(){
        System.out.println(title + " " + numberOfDays + " " + pricePerDay);
    }

    public double calculateTotalPrice() {
      double totalPrice = 0;
      totalPrice = this.numberOfDays * this.pricePerDay;
        System.out.println("total price: " + totalPrice) ;
        return totalPrice;
    }
    public void calculateTotalPrice(double reduction) {
        double totalPrice = 0;
        totalPrice = this.numberOfDays * this.pricePerDay - (this.numberOfDays * this.pricePerDay * reduction);
        System.out.println("total price: " + totalPrice) ;
    }

    public String toString() {
        return getTitle() +  " " + numberOfDays + " " + pricePerDay;
    }
}
