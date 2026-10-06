package lw03.unguided; 
import java.util.*; 

public class Main {
    public static void main(String[] args){
        Set<String> checkins = new LinkedHashSet<String>(); 
        Set<String> register = new LinkedHashSet<String>(); 

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt")); 
        while (sc1.hasNextLine()){
            String peserta = sc1.nextLine(); 
            register.add(peserta); 
        } 

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        int rejectAttemps = 0; 
        int success = 0; 

        System.out.println("===== Event Check-In Results =====");
        while(sc2.hasNextLine()){
            String id = sc2.nextLine(); 
            
            if (!register.contains(id)){
                System.out.println(id + " : Rejected (Not registered)");   
                rejectAttemps++;             
            }else if (checkins.contains(id)) {
                System.out.println(id + " : Rejected (already check in)");
                rejectAttemps++; 
            } else {
                checkins.add(id); 
                System.out.println(id + " : Check in");
                success++; 
            }  

        } 
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + register.size());
        System.out.println("Successful check-ins: " + success);
        System.out.println("Absent students: " + (register.size() - checkins.size())); 
        System.out.println("Rejected attempts: " + rejectAttemps); 

    }
}
