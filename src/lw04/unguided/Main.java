package lw04.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt")); 

        int n = sc.nextInt(); 
        int[] parcel = new int[n]; 
        for (int i = 0; i < n; i++) {
            parcel[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        BubbleSort(parcel, 0, 1);

        int[] duaPasses = new int[n];
        for (int i = 0; i < n; i++) {
            duaPasses[i] = parcel[i];
        }
        BubbleSort(parcel, 2, n-2);


        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < n; i++) {
            System.out.print(duaPasses[i] + " ");
        }
        System.out.println();
        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < n; i++) {
            System.out.print(parcel[i] + " ");
        }
        System.out.println();

        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++) {
            int[] hasil = BinarySearch(parcel, target[i]); 
            if (hasil[0] != -1) {
                System.out.println(target[i] + ": FOUND at index " + hasil[0] + " (steps: " + hasil[1] + ")");
            } else {
                System.out.println(target[i] + ": NOT FOUND (steps: " + hasil[1] + ")");
            }  
        }     
    }

    public static void BubbleSort(int[] isi, int awal, int akhir) {
    for (int i = awal; i <= akhir; i++) {
        for (int j = 0; j < isi.length - 1 - i; j++) {
            if (isi[j] < isi[j + 1]) {
                int baru = isi[j];
                isi[j] = isi[j + 1];
                isi[j + 1] = baru;
            }
        }
    }
    }

    public static int[] BinarySearch(int[] isi, int target) {
        int angkaAwal = 0;
        int angkaAkhir = isi.length - 1;
        int steps = 0;

        int[] hasil = new int[2];
        hasil[0] = -1;
        hasil[1] = 0;

        while (angkaAwal <= angkaAkhir) {
            int tengah = (angkaAwal + angkaAkhir) / 2;
            steps++;

            if (isi[tengah] == target) {
                hasil[0] = tengah;
                hasil[1] = steps;
                return hasil;
            } 
            else if (isi[tengah] < target) {
                angkaAkhir = tengah - 1;
            } 
            else {
                angkaAwal = tengah + 1;
            }
        }
        hasil[1] = steps;
        return hasil;
    }
}
