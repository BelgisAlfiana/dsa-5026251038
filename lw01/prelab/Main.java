import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("lw01/prelab/jobs.txt"));
         int i = 0;
        PrintJob[] jobs = new PrintJob[5];
        while (sc.hasNext()) {
            String label = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

            if (label.equals("MONO")) {
                jobs[i] = new Monoprint(id, pages);
            } else if (label.equals("COLOUR")) {
                jobs[i] = new Colourprint(id, pages);
            }
              i++;
        }
            for (int j = 0; j < i; j++) {
                System.out.println(jobs[j].summary());
            }
           
            
        sc.close();
    }
}