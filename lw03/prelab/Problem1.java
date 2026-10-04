
import java.util.*;  

public class Problem1 {

    //PROBLEM 1
    public static void main(String[] args){
    List<String> playlist = new ArrayList<>(); 

    Scanner sc = new Scanner(Problem1.class.getResourceAsStream("playlist.txt")); 
    while (sc.hasNext()) {
        String baris = sc.nextLine(); 
        String[] data = baris.split(" ", 2); 
        String perintah = data[0]; 

        if (perintah.equals("ADD")){
            playlist.add(data[1]); 
        }

        else if (perintah.equals("REMOVE")){
            playlist.remove(data[1]); 
        }

        else if (perintah.equals("INSERT")){
            String[] pisahData = data[1].split(" ", 2); 
            int index = Integer.parseInt(pisahData[0]);  

            playlist.add(index, pisahData[1] );
        }
    } sc.close(); 

    System.out.println("===== Problem 1 =====");
    System.out.println("Total Songs : " + playlist.size());
    for (int i = 0; i < playlist.size(); i++){
        System.out.println((i + 1) + ": " + playlist.get(i)); 
    }
   
    }
}

    