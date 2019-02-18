import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/* Author: Victor Fernando Carrasco Mena
*  Date: February 17 of 2019
* */
public class Aplication {
    public static void main(String[] args) throws IOException {
        Clasifier clasifier = new Clasifier();
        Employee employee = new Employee();
        String name;
        int count = 0;

        Scanner file = new Scanner(new File("C:\\Users\\Primario\\Documents\\GitHub\\ACME\\Roster\\roster.txt"));
        //reading the file
        FileReader fr = new FileReader("C:\\Users\\Primario\\Documents\\GitHub\\ACME\\Roster\\roster.txt");
        BufferedReader br = new BufferedReader(fr);
        //some important variables
        String string ;
        while (file.hasNextLine()){
            count++;
            string = br.readLine();
            clasifier.tokenize(employee,string);
            clasifier.tokenizeHours(employee);
            employee.setSalaryAmmount(clasifier.countTotalSalary(employee));
            name = employee.getName();
            System.out.println("The ammount to pay " + name + " is: " + employee.getSalaryAmmount() + " USD");
            file.nextLine();
        }
        //System.out.println("" + count);

    }
}
