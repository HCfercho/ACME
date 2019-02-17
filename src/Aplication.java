
public class Aplication {
    public static void main(String[] args) {
        Clasifier clasifier = new Clasifier();
        Employee employee = new Employee();
        float totalSalary;
        String name;

        clasifier.tokenize(employee);
        clasifier.tokenizeHours(employee);
        totalSalary = clasifier.countTotalSalary(employee);
        name = employee.getName();
        System.out.println("The ammount to pay " + name + " is: " + totalSalary + "USD");
    }
}
