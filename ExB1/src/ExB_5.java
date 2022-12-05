public class ExB_5 {

    public static void main(String[] args) {
        String name = "Bob";
        int age = 23;
        double grossSalary = 2700.00d;
        double annualSalary = grossSalary * 12;
        double tax = 0.48d;

        while (age <= 43) {
            if (annualSalary > 0 && annualSalary <= 13870) {
                tax = 0.25d;
            } else if (annualSalary > 13870 && annualSalary <= 24480) {
                tax = 0.40d;
            } else if (annualSalary > 24480 && annualSalary <= 42370) {
                tax = 0.45d;
            } else if (annualSalary > 42370) {
                tax = 0.50d;
            }

            double netSalary = grossSalary - grossSalary * tax;
            boolean senior = false;
            String textSenior = "";
            if (!senior) {
                textSenior = "NOT";
            }

            System.out.println(name + "'s net salary at " + age + " is " + netSalary);

            age += 2;
            grossSalary = grossSalary + grossSalary * 0.05;
            annualSalary = grossSalary * 12;
        }
    }

}
