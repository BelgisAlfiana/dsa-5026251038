import java.io.File;
import java.io.FileNotFoundException;
import java.util.*; 

public class Problem3 {
    public static void main(String[] args) throws FileNotFoundException{
        Map<String, Integer> penjualan = new LinkedHashMap<String, Integer>();
    
        Scanner sc = new Scanner(new File("lw03/prelab/inventory.txt"));
        //Scanner sc = new Scanner(Problem3.class.getResourceAsStream("inventory.txt")); 
        int gagal = 0; 
        while (sc.hasNext()){
            String type = sc.next(); 
            String product = sc.next(); 
            int quantity = sc.nextInt(); 

            if (type.equals("ADD")){
                 if (!penjualan.containsKey(product)){
                    penjualan.put(product, quantity); 
                 }
                 else {
                    int stock = penjualan.get(product); 
                    penjualan.put(product, stock + quantity); 
                 }
            }

            else if (type.equals("SELL")){
                 
                if (!penjualan.containsKey(product)){
                    penjualan.remove(product, quantity);
                    gagal++;  
                }
                else {
                    int stock = penjualan.get(product);
                    if (stock >= quantity){
                    penjualan.put(product, stock - quantity); 
                    }
                    else {
                        gagal++; 
                    }
                }
            } 
        }sc.close(); 

        System.out.println("===== Problem 3 =====");
            for (Map.Entry<String, Integer> entry : penjualan.entrySet()){
                System.out.println(entry.getKey()+ " : " + entry.getValue());
            }
        System.out.println("Failed sales: " + gagal);
    }
}
