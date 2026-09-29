// package prelab;
// import java.util.*; 

// public class pembahasan {
//     public static void main(String[]args){
//         LinkedList<String[]> transactions = new LinkedList<>(); 
//         LinkedList<String[]> customers  = new LinkedList<>(); 

//         Queue<String[]> urutan = new LinkedList<>(); 
//         Stack<String[]> failed = new Stack<>(); 

//         Scanner sc = new Scanner(pembahasan.class.getResourceAsStream("transactions.txt"));  
//         while (sc.hasNext()){
//             String[] transaksi = new String[3]; 
//             transaksi[0] = sc.next(); 
//             transaksi[1] = sc.next();
//             transaksi[2] = sc.next();
//             transactions.add(transaksi); 
//         }
//         sc.close(); 

//         urutan.addAll(transactions); 

//         while (!urutan.isEmpty()){
//             String[] transaksi = urutan.poll(); 

//             String name = transaksi[0]; 
//             String type = transaksi[1]; 
//             int amount = Integer.parseInt(transaksi[2]); 

//             String[] pembeli = null; 

//             for (String[] cek : pembeli){
//                 if (cek[0].equals(name)){
//                     pembeli = cek; 
//                     break;
//                 }
//             }
//             if (pembeli == null){
//                 pembeli = new String[]{name, "0"}; 
//                 customers.add(pembeli); 
//             }
//             int balance = Integer.parseInt(pembeli[1]);

//             if (type.equals("DEPOSIT")) { 
//                     balance += amount; 
//                     pembeli[1] = String.valueOf(balance); 
//                     }

//             else if (type.equals("WITHDRAW")) { 
//                     if (amount <= balance) { 
//                            balance -= amount; 
//                            pembeli[1] = String.valueOf(balance);  
//                     }
//                     else { 
//                           failed.push(transactions);  
//                         }
//                 }  
//         }
//     }
// }
