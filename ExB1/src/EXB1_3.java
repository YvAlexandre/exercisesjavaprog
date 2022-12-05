public class EXB1_3 {
    public static void main(String[] args) {
        String name = "Bob";
        int age = 43;
        float grossSalary = 3216.54f;
        float annualSalary = grossSalary * 12;
        float tax = 0.48f;

        if (annualSalary > 0 && annualSalary <= 13870) {
            tax = 0.25f;
        } else if (annualSalary > 13870 && annualSalary <= 24480) {
            tax = 0.40f;
        } else if (annualSalary > 24480 && annualSalary <= 42370) {
            tax = 0.45f;
        } else if (annualSalary > 42370) {
            tax = 0.50f;
        }

        float netSalary = grossSalary - grossSalary * tax;
        boolean senior = false;

        System.out.println(name + " is " + age + " years old." + "Gross salary is " + netSalary + ". Senior:" + senior);
    }
}
