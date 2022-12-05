public class EXB1_2 {
    public static void main(String[] args) {
        String name = "Bob";
        int age = 43;
        float grossSalary = 3216.54f;
        float tax = 0.48f;
        float netSalary = grossSalary - grossSalary * tax;
        boolean senior = false;

        System.out.println(name + " is " + age + " years old." + "Gross salary is " + netSalary + ". Senior:" + senior  );
    }
}
