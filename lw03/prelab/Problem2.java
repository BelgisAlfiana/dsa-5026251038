import java.util.*; 
public class Problem2 {
    public static void main(String[] args) {
        //PROBLEM 2
    Set<String> students = new LinkedHashSet<String>(); 

    Scanner sc = new Scanner(Problem2.class.getResourceAsStream("participants.txt")); 
    
    int duplicate = 0; 
    while (sc.hasNext()){
        String nama = sc.nextLine();

        if(students.contains(nama)){
            duplicate ++; 
        }
        else {
            students.add(nama); 
        }
    }
    sc.close(); 

    System.out.println("===== Problem 2 ====="); 
    System.out.println("Unique participants: " + students.size()); 
        int nomor = 1; 
        for (String nama : students){
            System.out.println(nomor  + ". " + nama); 
            nomor++; 
        }
    System.out.println("Duplicate registrations: " + duplicate); 
    }
}
