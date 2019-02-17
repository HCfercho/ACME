import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Aplication {
    public static void main(String[] args) {
        Clasifier clasifier = new Clasifier();
        Employee employee = new Employee();
        clasifier.tokenize(employee);
        clasifier.tokenizeHours(employee);
    }
}
