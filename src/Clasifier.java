
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Clasifier {


    public Clasifier() {
    }

    public void tokenize(Employee employee, String employeeBuffer){
        try {
            // some aux strings
            String schedule;
            String day;
            List<String> days = new ArrayList<>();

            // tokenizer for each line of the text
            StringTokenizer tok = new StringTokenizer(employeeBuffer,"=");
            employee.setName(tok.nextToken());
            schedule = tok.nextToken();
            //System.out.println(""+employee.getName());
            //System.out.println(""+schedule);

            // tokenizer for each day of the employee's schedule
            StringTokenizer tok_schedule = new StringTokenizer(schedule,",");

            while(tok_schedule.hasMoreElements()){

                day = tok_schedule.nextToken();
                days.add(day);
                employee.setDays(days);
                //System.out.println(""+ employee.getDays());
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
            // separate the hours from the day
            hours = employee.getDays().get(day_position).substring(2);
            employee.getHours().add(hours);
            //System.out.println(employee.getDays().get(day_position));
            //System.out.println(employee.getHours());
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
        String[] firstHourPart = firstHour.split(":");
        String[] lastHourPart = lastHour.split(":");
        workedHours = Integer.valueOf(lastHourPart[0]) - Integer.valueOf(firstHourPart[0]);
        //System.out.println(firstHour + " to " + lastHour);

        return workedHours;
    }

    public float countTotalSalary(Employee employee){
        int number_of_days = employee.getDays().size();
        int day_position;
        float salary = 0;
        String day;
        float workedHours;
        //Regular expresions for each case
        Pattern patMo_Fri1 = Pattern.compile("(MO|TU|TH|WE|FR)0[0-8]:00-0[1-9]:00");
        Pattern patMo_Fri2 = Pattern.compile("(MO|TU|TH|WE|FR)((1[0-9]:00-1[0-8]:00)|(09:00-1[0-8]:00))");
        Pattern patMo_Fri3 = Pattern.compile("(MO|TU|TH|WE|FR)((1(8|9):00-(1|2)[0-9]:00)|(1(8|9):00-00:00)|(2[0-9]:00-(1|2)[0-9]:00)|(2[0-9]:00-00:00))");
        Pattern patSa_Su1 = Pattern.compile("(SA|SU)0[0-8]:00-0[1-9]:00");
        Pattern patSa_Su2 = Pattern.compile("(SA|SU)((1[0-9]:00-1[0-8]:00)|(09:00-1[0-8]:00))");
        Pattern patSa_Su3 = Pattern.compile("(SA|SU)((1(8|9):00-(1|2)[0-9]:00)|(1(8|9):00-00:00)|(2[0-9]:00-(1|2)[0-9]:00)|(2[0-9]:00-00:00))");
        //Matchers to compare the day string with the corresponding regular expression
        Matcher mat1;
        Matcher mat2;
        Matcher mat3;
        Matcher mat4;
        Matcher mat5;
        Matcher mat6;

        for (day_position = 0; day_position < number_of_days; day_position++){
            //store the day
            day = employee.getDays().get(day_position);
            //comparison using the regular expressions
            mat1 = patMo_Fri1.matcher(day);
            mat2 = patMo_Fri2.matcher(day);
            mat3 = patMo_Fri3.matcher(day);
            mat4 = patSa_Su1.matcher(day);
            mat5 = patSa_Su2.matcher(day);
            mat6 = patSa_Su3.matcher(day);
            // count worked hours
            workedHours = countWorkedHours(employee,day_position);

            if(mat1.find()){
                salary = salary + workedHours*25;
            }else if(mat2.find()){
                salary = salary + workedHours*15;
            }else if(mat3.find()){
                salary = salary + workedHours*20;
            }else if(mat4.find()){
                salary = salary + workedHours*30;
            }else if (mat5.find()){
                salary = salary + workedHours*20;
            }else if (mat6.find()){
                salary = salary + workedHours*25;
            }

            //System.out.println(workedHours);
        }

        return salary;
    }
}
