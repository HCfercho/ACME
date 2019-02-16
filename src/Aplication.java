import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Aplication {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\Primario\\Documents\\GitHub\\ACME\\Roster\\roster.txt");
            BufferedReader br = new BufferedReader(fr);
            String string = new String();
            String name;
            String schedule;
            string = br.readLine();
            // tokenizer for each line of the text
            StringTokenizer tok = new StringTokenizer(string,"=");
            name = tok.nextToken();
            schedule = tok.nextToken();
            // tokenizer for each day of the employee's schedule
            StringTokenizer tok_schedule = new StringTokenizer(schedule,",");
            System.out.println(""+name);
            System.out.println(""+schedule);
            String day;
            /*while((string=br.readLine())!=null){
                System.out.println(""+string);
            }*/


        }catch (Exception e){

        }
    }
}
