import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private List<String> days = new ArrayList<>();
    private List<String> hours = new ArrayList<>();
    private float SalaryAmmount;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getHours() {
        return hours;
    }

    public void setHours(List<String> hours) {
        this.hours = hours;
    }

    public float getSalaryAmmount() {
        return SalaryAmmount;
    }

    public void setSalaryAmmount(float salaryAmmount) {
        SalaryAmmount = salaryAmmount;
    }
}
