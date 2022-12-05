package be.ing;

import be.ing.exception.PriceException;
import be.ing.exception.PriceTooHighException;
import be.ing.exception.CompanyNotFoundException;
import be.ing.repository.CompanyRepository;
import be.ing.repository.MemoryListCompanyRepository;
import be.ing.service.*;
import be.ing.utilities.DateUtils;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        CompanyRepository cr = new MemoryListCompanyRepository();

        Course c1;
        c1 = new Course("Java",5,50);
        c1.printInfo();
        c1.calculateTotalPrice(0.05);

        /*Company co1;
        co1 = new Company("Abis");
        System.out.println(co1.toString());

        Company co2;
        co2 = new Company("IBM");
        System.out.println(co2.toString());*/

        Company comp1 = null;
        Company comp2 = null;
        Company comp3 = null;

        try {
            comp1 = cr.findCompany(1);
            comp2 = cr.findCompany("smals");
            comp3 = cr.findCompany(4);

            Company[] comps = {comp1,comp2,comp3};

            for (Company c: comps){
                System.out.println(c);
            }

            cr.addCompany(new Company(6,"ABBA5"));
            comp1.setName("SIBA");
            cr.updateCompany(comp1);
            cr.deleteCompany(3);

            List<Company> allCompanies = ((MemoryListCompanyRepository)cr).getCompanies();
            System.out.println(allCompanies);

        } catch (CompanyNotFoundException cnf){
            cnf.printStackTrace();
        }



        /*be.ing.Person p1, p2;
        p1 = new be.ing.Person("Mary","Jones",co1);
        p2 = new be.ing.Person("Mary","Jones");
        p1.printInfo();
        p2.printInfo();*/

        Person persons[] = new Person[2];


        persons[0]=new Person("Mary","Jones",comp1);
        persons[1]=new Person("John","Doe");

        persons[1].attendCourse(c1);

        persons[0].addHobbies("tennis","tennis");
        persons[1].addHobbies("running","football");

        for (int i=0; i< persons.length ;i++ ) {
            persons[i].printInfo();
        }

        /*be.ing.service.Session s1,s2;
        s1 = new be.ing.service.Session(c1,"24/11/2022",co1,persons[0]);
        s1.printInfo();
        s2 = new be.ing.service.CompanySession(c1,"25/11/2022",co1,persons[1],5);
        s2.printInfo();*/

       /*       be.ing.service.Session sessions[] = new be.ing.service.Session[2];
        sessions[0]=new be.ing.service.PublicSession(c1,"24/11/2022",co1,persons[0]);
        sessions[1]=new be.ing.service.CompanySession(c1,"25/11/2022",co2,persons[1],5);

        for (int i=0; i< sessions.length ;i++ ) {
            sessions[i].printInfo();
        }*/

        Service services[] = new Service[3];
        services[0]=new PublicSession(c1, DateUtils.parse("24/11/2022"),comp1,persons[0]);
        services[1]=new CompanySession(c1,DateUtils.parse("25/11/2022"),comp1,persons[1],5);
        services[2]=new Consultancy();

        for (int i=0; i< services.length ;i++ ) {
            System.out.println(services[i].getClass().toString());
            switch (services[i].getClass().toString()) {
                case "class be.ing.service.PublicSession":
                    services[i].printInfo();
                    break;
                case "class be.ing.service.CompanySession":
                    services[i].printInfo();
                    break;
                default:
            };
            try {
                if( services[i] instanceof CompanySession){
                    ((CompanySession)services[i]).calculatePrice();
                }
            } catch (PriceTooHighException e) {
                System.out.println(e.getMessage());
                    throw new RuntimeException(e);
            }
            finally {
                System.out.println("end");
            }
        }

        /*try {
            double offer =co1.requestPriceOfferForCompanySession(c1,8);
            System.out.println("The price offer is "  +offer);
        } catch (be.ing.exception.PriceTooHighException e) {
            System.out.println(e.getMessage());
        }
          catch (be.ing.exception.PriceTooLowException e) {
                System.out.println(e.getMessage());
        }*/

        try {
            double offer =comp1.requestPriceOfferForCompanySession(c1,2);
            System.out.println("The price offer is "  +offer +".");
        } catch (PriceException e) {
            System.out.println(e.getMessage());
        }

        PublicSession publicSession = new PublicSession(c1, DateUtils.parse("15/11/2022"),comp1,persons[0]);


        Person p1 = new Person("Mary","Jones",comp1);
        Person p2=new Person("John","Doe");
        Person p3 = new Person("Bob","Janssens",comp3);
        Person p4 = new Person("An","Smets", comp2);
        Person p5 = new Person("Sam","Smets", comp2);

        /*publicSession.addEnrolment(p1);
        publicSession.addEnrolments(p4,p5);
        publicSession.addEnrolment(p3);
        publicSession.cancelEnrolment(p2);*/

        List<CourseParticipant> participants = publicSession.getEnrolments();
        System.out.println(participants);

    }
}
