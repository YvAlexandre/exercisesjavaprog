package be.ing;

import be.ing.service.Company;
import java.util.HashSet;
import java.util.Set;


public class Person {
    private String firstName;
    private String lastName;
    private Company company;
    private static int counter = 0;
    private int personNumber;

    /*public String[] getHobbies() {
        return hobbies;
    }*/

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    /*public void addHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }*/



    //private String[] hobbies=new String[10];
    private Set<String> hobbies=new HashSet<>();
    private int hobbiesIndex;

    /*public void addHobby(String hobby){

        String[] temphob = new String[this.hobbies.length + 1];
        for (int cnt = 0; cnt < this.hobbies.length; cnt++) {
            temphob[cnt] = this.hobbies[cnt];
        }
        this.hobbies = temphob;

    }*/

    /*public void addHobby(String hobby){
        hobbies[hobbiesIndex]=hobby;
        hobbiesIndex++;
    }*/

    public void addHobby(String hobby){
        hobbies.add(hobby);
    }

    /** adding hobbies based on a vararg**/
    public void addHobbies(String... hobbies){
        for (String hobby:hobbies){
            this.addHobby(hobby);
        }
    }

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        personNumber = counter;
        counter = counter +1;
    }

    public Person(String firstName, String lastName, Company company) {
        this(firstName, lastName);
          this.company = company;
          personNumber = counter;
          counter = counter +1;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public void printInfo() {
        if (this.company==null  ) {
            System.out.println(getFirstName() + " " + getLastName() + " nbr " + this.personNumber + " is not linked to a company");
        } else {
            System.out.println(getFirstName() + " " + getLastName() + " nbr " + this.personNumber +  " " + getCompany().getName());
            for (String str : this.getHobbies())
            {
                System.out.println(str);
            }
        }
    }
    public void attendCourse(Course c){
        System.out.println(getFirstName() + " is attending a " + c.getTitle()  + " course");
    }
    public String toString(Course c) {
        return getFirstName() + " is attending a " + c.getTitle()  + " course";
    }

}
