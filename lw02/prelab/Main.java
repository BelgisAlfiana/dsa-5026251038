package prelab; 
import java.io.File;
import java.io.FileNotFoundException; 

import java.util.LinkedList; 
import java.util.Scanner; 
import java.util.Stack; 
import java.util.Queue; 



public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("lw02/prelab/transactions.txt")); 

        LinkedList<String[]> transaksi = new LinkedList<>(); 
        LinkedList<String[]> customer = new LinkedList<>(); 

        while (sc.hasNext()) {
            String name = sc.next();
            String type = sc.next();
            String amount = sc.next();

            String[] transaction = {name, type, amount}; 
            transaksi.add(transaction); 
        
            boolean sudahAda = false; 
            for (String[] pelanggan : customer) { 
                if (pelanggan[0].equals(name)) { 
                    sudahAda = true; 
                    break; 
                } 
            }
            if (!sudahAda) {
                    String[] dataCustomer = {name, "0"}; 
                    customer.add(dataCustomer); 
                } 

        } sc.close();
        
            Queue<String[]> urutan = new LinkedList<>(); 
                while (!transaksi.isEmpty()) {
                    urutan.offer(transaksi.removeFirst());
            }

            Stack<String[]> gagal = new Stack<>();

            while (!urutan.isEmpty()){
                String[] transaction = urutan.poll(); 
                String name = transaction[0]; 
                String type = transaction[1]; 
                int amount = Integer.parseInt(transaction[2]);
         
                for (String[] pelanggan : customer) {
                    if (pelanggan[0].equals(name)) {
                        int balance = Integer.parseInt(pelanggan[1]);
                    
                        if (type.equals("DEPOSIT")) { 
                            balance += amount; 
                            pelanggan[1] = String.valueOf(balance); 
                        }
                        else if (type.equals("WITHDRAW")) { 
                            if (amount > balance) { 
                            gagal.push(transaction); 
                            }
                            else { 
                                balance -= amount; 
                                pelanggan[1] = String.valueOf(balance); 
                            }
                        } break; 
                    } 
                }
            }
            System.out.println("=== Final Balances ===");

            for (String[] pelanggan : customer) {
                System.out.println(pelanggan[0] + " : " + pelanggan[1]);
            }

            System.out.println();
            System.out.println("=== Failed Transactions ===");

            while (!gagal.isEmpty()) {
            String[] transaction = gagal.pop();

            System.out.println(
                transaction[0] + " "
                + transaction[1] + " "
                + transaction[2]
            );
        }
            
         
    }
}
