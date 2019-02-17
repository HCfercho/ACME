import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Aplication {
    public static void main(String[] args) {
        try {
            //reading the file
            FileReader fr = new FileReader("C:\\Users\\Primario\\Documents\\GitHub\\ACME\\Roster\\roster.txt");
            BufferedReader br = new BufferedReader(fr);
            //some important variables
            String string = new String();
            String schedule = new String();
            String day;
            List<String> days = new ArrayList<>();

            //Instantiating the object Employee
            Employee employee = new Employee();
            string = br.readLine();

            // tokenizer for each line of the text
            StringTokenizer tok = new StringTokenizer(string,"=");
            employee.setName(tok.nextToken());
            schedule = tok.nextToken();
            System.out.println(""+employee.getName());
            System.out.println(""+schedule);

            // tokenizer for each day of the employee's schedule
            StringTokenizer tok_schedule = new StringTokenizer(schedule,",");

            while(!tok.hasMoreElements()){

                day = tok_schedule.nextToken();
                days.add(day);
                employee.setDays(days);
                System.out.println(""+ employee.getDays());
            }

        }catch (Exception e){
            System.out.println("The file couldn't be opened "+ e);
        }
    }
}
