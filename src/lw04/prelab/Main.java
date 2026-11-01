package lw04.prelab;

import java.util.*; 

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt(); 
        int[] branches = new int[n]; 

        for (int i = 0; i < n; i++){
            branches[i] = sc.nextInt(); 
        }

        int m = sc.nextInt(); 
        int[] target = new int[m]; 

        for (int i = 0; i < m; i++){
            target[i] = sc.nextInt(); 
        }

        sortPertama(branches); 

        for (int i = 0; i < n; i++) {
            System.out.print(branches[i] + " ");
        }
        System.out.println();
        
         for (int i = 0; i < m; i++) {
            int hasil = cariLetak(branches, target[i]);
            if (hasil != -1) {
                System.out.println(target[i] + ": FOUND at index " + hasil);
            } else {
                System.out.println(target[i] + ": NOT FOUND");
            }
        }

    }

    public static void sortPertama(int[] isi){
        
        for (int i = 1; i <= 3; i++) {
            int key = isi[i];
            int j = i - 1;

            while (j >= 0 && isi[j] < key) {
                isi[j + 1] = isi[j];
                j--;
            }
            isi[j + 1] = key;
        }
    }

    public static int cariLetak(int[] isi, int target){
        
        for (int i = 0; i < isi.length; i++) {
            if (isi[i] == target) {
                return i;
            }
        }
        return -1; 
    }
}
