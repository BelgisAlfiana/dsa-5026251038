package unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack; 

public class Main {
    public static void main(String[] args){
        LinkedList<String[]> orders = new LinkedList<>(); 
        LinkedList<String[]> Foods = new LinkedList<>(); 
        LinkedList<String[]> Drinks = new LinkedList<>(); 
        LinkedList<String[]> processed = new LinkedList<>(); 

        Queue<String[]> queue = new LinkedList<>(); 
        Stack<String[]> failed = new Stack<>(); 

        Scanner sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        while (sc.hasNext()){
            String[] pesanan = new String[4]; 
            pesanan[0] = sc.next(); 
            pesanan[1] = sc.next();
            pesanan[2] = sc.next();
            pesanan[3] = sc.next(); 
            orders.add(pesanan); 

            
        }
        sc.close(); 
        
        String[] bakso = {"Bakso", "2"}; 
        String[] sate = {"Sate", "1"}; 
        String[] soto = {"Soto", "2"}; 
        Foods.add(bakso); 
        Foods.add(sate); 
        Foods.add(soto);
        
        String[] esTeh = {"EsTeh", "4"}; 
        String[] esJeruk = {"EsJeruk", "2"};  
        Drinks.add(esTeh); 
        Drinks.add(esJeruk); 

        queue.addAll(orders); 

        while (!queue.isEmpty()){
            String[] pesanan = queue.poll(); 

            String name = pesanan[0]; 
            String food = pesanan[1]; 
            String drink = pesanan[2]; 
            String nomor = pesanan[3]; 
            
            boolean foodAda = true;
            boolean drinkAda = true; 

            if(!food.equals("-")){
                for (String[] s : Foods){
                    if(s[0].equals(food)){
                        int jumlahFood = Integer.parseInt(s[1]); 
                        if (jumlahFood == 0) {
                            foodAda = false; 
                        }
                    }
                }
            }
             if(!drink.equals("-")){
                for (String[] s : Drinks){
                    if(s[0].equals(drink)){
                        int jumlahDrink = Integer.parseInt(s[1]); 
                        if (jumlahDrink == 0) {
                            drinkAda = false; 
                        }
                    }
                }
            }
            
            for (String[] cek : orders){
                if(cek[1].equals(food)){
                    for (String[] hitungFood : Foods){
                        if(hitungFood[0].equals(food)){
                            int jumlahFood = Integer.parseInt(hitungFood[1]);
                            if(jumlahFood > 0){
                                jumlahFood = jumlahFood - 1; 
                                hitungFood[1] = Integer.toString(jumlahFood); 
                                processed.add(pesanan); 
                            } 
                            else {
                                failed.push(pesanan); 
                            }
                            
                        }
                    }   
                }

                if(cek[2].equals(drink)){
                    for (String[] hitungDrink : Drinks){
                        if(hitungDrink[0].equals(drink)){
                            int jumlahDrink = Integer.parseInt(hitungDrink[1]);
                            if(jumlahDrink > 0){
                                jumlahDrink = jumlahDrink - 1; 
                                hitungDrink[1] = Integer.toString(jumlahDrink); 
                                processed.add(pesanan); 
                            } 
                            else {
                                failed.push(pesanan); 
                            }
                            
                        }
                    }   
                }
            }
        }

        System.out.println("=== Successfully Processed Orders ==="); 
        for(String[] a : processed){
            System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]); 
        }

        System.out.println("=== Remaining Food Stock ===");
        for(String[] b : Foods){
            System.out.println(b[0] + " " + b[1]); 
        }

        System.out.println("=== Remaining Drink Stock ===");
        for(String[] c : Drinks){
            System.out.println(c[0] + " " + c[1]); 
        }
        System.out.println("=== Failed Orders ===");
        for(String[] d : failed){
            while(!failed.isEmpty()){
               String[] gagal = failed.pop(); 
               System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2] + " " + gagal[3]); 

            }
        }
    }
}
