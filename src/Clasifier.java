import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Clasifier {

    private int ammount;
    public Clasifier() {
    }

    public int clasify(Employee employee){
        int i;
        for (String day:employee.getDays() ) {
            switch (day){
                case "MO":

                case "TU":

                case "WE":
            }
        }

        return ammount;
    }

    public void tokenize(Employee employee){
        try {
            //reading the file
            FileReader fr = new FileReader("C:\\Users\\Primario\\Documents\\GitHub\\ACME\\Roster\\roster.txt");
            BufferedReader br = new BufferedReader(fr);
            //some important variables
            String string ;
            String schedule;
            String day;
            List<String> days = new ArrayList<>();

            //Getting the information of each line
            string = br.readLine();

            // tokenizer for each line of the text
            StringTokenizer tok = new StringTokenizer(string,"=");
            employee.setName(tok.nextToken());
            schedule = tok.nextToken();
            System.out.println(""+employee.getName());
            System.out.println(""+schedule);

            // tokenizer for each day of the employee's schedule
            StringTokenizer tok_schedule = new StringTokenizer(schedule,",");

            while(tok_schedule.hasMoreElements()){

                day = tok_schedule.nextToken();
                days.add(day);
                employee.setDays(days);
                System.out.println(""+ employee.getDays());
            }

        }catch (Exception e){
            System.out.println("The file couldn't be opened "+ e);
        }
    }

    public void tokenizeHours(Employee employee){
        int number_of_days = employee.getDays().size();
        int day_position;

        for (day_position = 0; day_position < number_of_days; day_position++) {
            //needed strings
            String hours;
            float workedHours;
            // separate the hours from the day
            hours = employee.getDays().get(day_position).substring(2);
            employee.getHours().add(hours);
            System.out.println(employee.getDays().get(day_position));
            System.out.println(employee.getHours());
            // count worked hours
            workedHours = countWorkedHours(employee,day_position);
            System.out.println(workedHours);
        }
    }

    public float countWorkedHours(Employee employee,int position){
        float workedHours=0;
        String firstHour;
        String lastHour;
        
        // Split the beginning hour and the finishing hour
        String[] hoursParts = employee.getHours().get(position).split("-");
        firstHour = hoursParts[0];
        lastHour = hoursParts[1];
        workedHours = Integer.valueOf(firstHour);
        System.out.println(firstHour + " to " + lastHour);

        return workedHours;
    }
}
